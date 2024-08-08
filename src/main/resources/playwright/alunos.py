import csv
from playwright.sync_api import sync_playwright
import time

def ler_alunos():
    abrindo_csv = open('C:\\Users\\Marcos\\Documents\\automacao\\alunos.csv', 'r')
    alunos = csv.reader(abrindo_csv, delimiter=';')
    alunos_lista = []
    
    for row in alunos:
        if len(row) != 0:
            nome = row[0]
            endereco = row[1]
            curso = row[2]
            numero = row[3]
            bairro = row[4]
            cidade = row[5]
            alunos_lista.append([nome, endereco, curso, numero, bairro, cidade])
    return alunos_lista


with sync_playwright() as p:
    alunos = ler_alunos()

    navegador = p.chromium.launch(headless=False)
    pagina = navegador.new_page()
    pagina.goto("http://localhost:8080/login")
    time.sleep(1)
    pagina.fill('//*[@id="inputEmail"]', 'admin@suap.edu.br')
    time.sleep(1)
    pagina.fill('//*[@id="inputPassword"]', 'admin')
    time.sleep(1)
    pagina.locator('//*[@id="form-container"]/div/div[1]/form/input[2]').click()
    pagina.goto('http://localhost:8080/alunos/cadastrar')
    for aluno in alunos:
        pagina.fill('//*[@id="nome"]', aluno[0])
        pagina.fill('//*[@id="rua"]', aluno[1])
        pagina.locator('//*[@id="cursos"]').select_option(label=f'{aluno[2]}')
        pagina.fill('//*[@id="numero"]', aluno[3])
        pagina.fill('//*[@id="bairro"]', aluno[4])
        pagina.fill('//*[@id="cidade"]', aluno[5])
        pagina.locator('//*[@id="cadastro"]/form/button').click()
    pagina.locator('//*[@id="navbarsExampleDefault"]/a').click()
    pagina.screenshot(path='cadastroDeAlunos.png', full_page=True)
    time.sleep(10)
