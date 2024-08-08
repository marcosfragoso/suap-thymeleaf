import csv
from playwright.sync_api import sync_playwright
import time

def ler_cursos():
    abrindo_csv = open('D:\\Users\\Marcos\\Documents\\suap-thymeleaf\\src\\main\\resources\playwright\\curso.csv', 'r')
    cursos = csv.reader(abrindo_csv, delimiter=';')
    cursos_lista = []
    
    for row in cursos:
        if len(row) != 0:
            curso = row[0]
            area = row[1]
            cursos_lista.append([curso, area])
    return cursos_lista


with sync_playwright() as p:
    cursos = ler_cursos()

    navegador = p.chromium.launch(headless=False)
    pagina = navegador.new_page()
    pagina.goto("http://localhost:8080/login")
    pagina.fill('//*[@id="inputEmail"]', 'admin@suap.edu.br')
    pagina.fill('//*[@id="inputPassword"]', 'admin')
    pagina.keyboard.press('Enter')
    pagina.locator('//html/body/div/aside/nav/ul[2]/li[2]/a/span').click()
    for curso in cursos:
        pagina.fill('//*[@id="nome"]', curso[0])
        pagina.fill('//*[@id="area"]', curso[1])
        pagina.locator('//*[@id="cadastro"]/form/button').click()
    pagina.locator('//*[@id="navbarsExampleDefault"]/a').click()
    pagina.screenshot(path='screenshots/cadastro-cursos.png', full_page=True)
    time.sleep(3)
