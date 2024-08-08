# SUAPDoSertão
Este projeto é um sistema simples inspirado em um controle acadêmico, desenvolvido para gerenciar informações relacionadas a uma instituição de ensino. O sistema foi projetado para lidar com as principais entidades encontradas em um ambiente acadêmico, incluindo Alunos, Usuários, Professores, Matrículas, Disciplinas e Cursos.
# Funcionalidades
- Gerenciamento de Alunos: Cadastro, atualização e consulta de informações dos alunos.
- Gerenciamento de Usuários: Controle de acesso e permissões através de diferentes perfis de usuário.
- Gerenciamento de Professores: Cadastro e gerenciamento de informações dos professores.
- Matrículas: Registro de matrículas dos alunos e histórico.
- Gerenciamento de Disciplinas: Criação e gerenciamento de disciplinas.
- Gerenciamento de Cursos: Administração dos cursos oferecidos pela instituição, incluindo a associação de disciplinas.
# Tecnologias
- Java 22: Linguagem de programação principal do projeto.
  
- Spring Boot 3.3.2: Framework para construção de aplicações web robustas e escaláveis.
  - Spring Data JPA: Abstração de persistência para interagir com bancos de dados relacionais.
  - Spring Web: Módulo para criação de aplicações web e APIs RESTful.
  - Spring Security: Gerenciamento de autenticação e autorização.
  - Spring Boot DevTools: Ferramentas para desenvolvimento, incluindo live reload.
  - Spring Boot Starter Test: Conjunto de ferramentas de teste para aplicações Spring.
  - Spring Boot Starter Thymeleaf: Integração com o mecanismo de templates Thymeleaf.
  - Spring Boot Starter Validation: Suporte para validação de dados.
  
- Thymeleaf: Motor de templates para renderização de páginas HTML.
  - Thymeleaf Layout Dialect: Suporte para layouts reutilizáveis com Thymeleaf.
  - Thymeleaf Extras SpringSecurity6: Integração do Thymeleaf com Spring Security.
  
- PostgreSQL: Banco de dados relacional utilizado para persistência dos dados.
  
- Lombok: Biblioteca para reduzir a verbosidade do código Java, especialmente em relação a getters, setters e construtores.
  
- JasperReports: Ferramenta para geração de relatórios.
  
- Apache Commons Text: Biblioteca para manipulação de textos e strings.

- Python 3: Linguagem utilizada em scripts auxiliares e automações.
  
- Playwright: Ferramenta para automação de testes e inserção de dados.

# Como executar
1. Com o PostgreSQL instalado, configure o mesmo de acordo com o arquivo [application.properties](https://github.com/marcosfragoso/suap-thymeleaf/blob/master/src/main/resources/application.properties)
2. Em seguida, execute os scripts de configurações iniciais da base de dados [scripts](https://github.com/marcosfragoso/suap-thymeleaf/blob/master/src/main/resources/sql/suap-sql-postgres.sql)
3. Pronto, a base de dados está configurada e você pode startar o projeto na url `http://localhost:8080/`
4. Para o uso da automação instale as libs do playwright no terminal:
     
   ```
   pip install pytest-playwright
   playwright install
   ```
5. Pronto, agora está tudo finalizado. Lembrando que a senha para todos os logins é `admin` e que os e-mails você encontra nos [INSERTS](https://github.com/marcosfragoso/suap-thymeleaf/blob/master/src/main/resources/sql/suap-sql-postgres.sql)
