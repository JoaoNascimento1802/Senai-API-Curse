# Senai-API-Curse

![GitHub repo size](https://img.shields.io/github/repo-size/JoaoNascimento1802/Senai-API-Curse?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/JoaoNascimento1802/Senai-API-Curse?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/JoaoNascimento1802/Senai-API-Curse?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/JoaoNascimento1802/Senai-API-Curse?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/JoaoNascimento1802/Senai-API-Curse?style=for-the-badge)


> Pequeno Projeto para o Senai sobre uma api em Java , ainda irei realizar o front-end.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente do Java 11 ou superior.
- Você tem uma máquina que suporta Spring Boot e MySQL (Windows, Linux ou macOS).
- Você leu a [documentação do Spring Boot](https://spring.io/projects/spring-boot) para entender os requisitos do ambiente.

## 🚀 Instalando Senai-API-Curse

Para instalar o **Senai-API-Curse**, siga estas etapas:

### Linux e macOS:

1. Clone o repositório:
    ```bash
    git clone https://github.com/JoaoNascimento1802/Senai-API-Curse.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd Senai-API-Curse
    ```

3. Rode o comando de build com Maven:
    ```bash
    ./mvnw clean install
    ```

### Windows:

1. Clone o repositório:
    ```bash
    git clone https://github.com/JoaoNascimento1802/Senai-API-Curse.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd Senai-API-Curse
    ```

3. Rode o comando de build com Maven:
    ```bash
    mvnw.cmd clean install
    ```

## ☕ Usando Senai-API-Curse

Para usar **Senai-API-Curse**, siga estas etapas:

1. Após a instalação, rode o seguinte comando para iniciar a aplicação:
    ```bash
    ./mvnw spring-boot:run
    ```

2. Acesse a API na URL:
    ```bash
    http://localhost:8080
    ```


## 📅 Seeding do Banco de Dados

Para realizar o seeding do banco de dados no **Senai-API-Curse**, siga os passos abaixo para configurar as tabelas e inserir dados de exemplo.

1. Crie o banco de dados:

    ```sql
    CREATE DATABASE bancoteste;
    ```

2. Verifique as tabelas:

    ```sql
    SHOW TABLES;
    ```

3. Descreva as tabelas para verificar a estrutura:

    ```sql
    DESC tb_atividade;
    DESC tb_bloco;
    DESC tb_categoria;
    DESC tb_participante;
    DESC tb_participante_atividade;
    ```

4. Insira categorias no banco de dados:

    ```sql
    INSERT INTO tb_categoria (descricao) VALUES 
        ('Palestra'), 
        ('Curso'), 
        ('Oficina'), 
        ('Seminário'), 
        ('Workshop');
    ```

5. Insira atividades:

    ```sql
    INSERT INTO tb_atividade (nome, descricao, preco, categoria_id) 
    VALUES 
        ('Curso de Java', 'Aprenda Java do zero', 50.00, 2),
        ('Oficina de Design Gráfico', 'Workshop sobre design digital', 30.00, 3),
        ('Palestra sobre IA', 'Inteligência Artificial no mercado', 0.00, 1),
        ('Seminário de Ciência de Dados', 'Técnicas avançadas de análise de dados', 20.00, 4),
        ('Workshop de UX/UI', 'Melhores práticas de experiência do usuário', 40.00, 5),
        ('Curso de Spring Boot', 'Desenvolvimento web com Spring', 60.00, 2),
        ('Palestra sobre Cyber Segurança', 'Protegendo dados na internet', 0.00, 1),
        ('Oficina de Arduino', 'Criando projetos eletrônicos', 35.00, 3);
    ```

6. Insira participantes:

    ```sql
    INSERT INTO tb_participante (nome, email) 
    VALUES 
        ('Ana Silva', 'ana@email.com'),
        ('Carlos Souza', 'carlos@email.com'),
        ('Mariana Oliveira', 'mariana@email.com'),
        ('José Ferreira', 'jose@email.com'),
        ('Lucas Martins', 'lucas@email.com'),
        ('Fernanda Costa', 'fernanda@email.com'),
        ('Ricardo Mendes', 'ricardo@email.com'),
        ('Patrícia Lima', 'patricia@email.com'),
        ('Gabriel Rocha', 'gabriel@email.com'),
        ('Juliana Castro', 'juliana@email.com');
    ```

7. Insira blocos de horário:

    ```sql
    INSERT INTO tb_bloco (inicio, fim, atividade_id) 
    VALUES 
        ('2025-03-01 09:00:00', '2025-03-01 12:00:00', 1),
        ('2025-03-01 14:00:00', '2025-03-01 17:00:00', 1),
        ('2025-03-02 10:00:00', '2025-03-02 12:00:00', 2),
        ('2025-03-02 14:00:00', '2025-03-02 16:00:00', 3),
        ('2025-03-03 09:00:00', '2025-03-03 11:00:00', 4),
        ('2025-03-04 15:00:00', '2025-03-04 18:00:00', 5),
        ('2025-03-05 08:00:00', '2025-03-05 12:00:00', 6),
        ('2025-03-06 10:00:00', '2025-03-06 14:00:00', 7),
        ('2025-03-07 09:30:00', '2025-03-07 11:30:00', 8);
    ```

8. Inscreva participantes nas atividades:

    ```sql
    INSERT INTO tb_participante_atividade (participante_id, atividade_id) 
    VALUES 
        (1, 1), (1, 2), (1, 3), 
        (2, 4), (2, 5), 
        (3, 6), (3, 7), 
        (4, 8), (4, 1), 
        (5, 2), (5, 3), 
        (6, 4), (6, 5), (6, 6), 
        (7, 7), (7, 8), 
        (8, 1), (8, 2), 
        (9, 3), (9, 4), 
        (10, 5), (10, 6), (10, 7), (10, 8);
    ```

9. Verifique se os dados foram inseridos corretamente:

    ```sql
    SELECT * FROM tb_categoria;
    SELECT * FROM tb_atividade;
    SELECT * FROM tb_participante;
    SELECT * FROM tb_bloco;
    SELECT * FROM tb_participante_atividade;
    ```


## 📫 Contribuindo para Senai-API-Curse

Para contribuir com **Senai-API-Curse**, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_branch>`
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#" title="https://github.com/JoaoNascimento1802">
        <img src="https://i.pinimg.com/736x/6d/83/b9/6d83b96e6f062c57dcbeb3e325ebcd10.jpg" width="100px;" alt="Foto do Emanuel no GitHub"/><br>
        <sub>
          <b>Emanuel</b>
        </sub>
      </a>
    </td>

## 📝 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.
