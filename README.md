# 🚨 Denúncia Escolar

Sistema desenvolvido em Java para registro e gerenciamento de denúncias no ambiente escolar.

---

## 📝 Sobre o Projeto

O objetivo do sistema é permitir o registro e acompanhamento de denúncias relacionadas ao ambiente escolar, promovendo um espaço mais seguro para estudantes e funcionários.

O projeto foi desenvolvido para praticar conceitos de Programação Orientada a Objetos (POO), Interface Gráfica (GUI) e Tratamento de Exceções em Java.

---

## ✨ Funcionalidades

✅ Registrar denúncias

✅ Consultar denúncias por protocolo

✅ Listar denúncias cadastradas

✅ Atualizar status das denúncias

✅ Encerrar denúncias

✅ Exibir mensagens de erro amigáveis

✅ Interface gráfica com Java Swing

---

## 🚨 Tipos de Denúncia

🏫 Bullying

⚠️ Assédio

🌎 Discriminação

🔨 Vandalismo

---

## 🧠 Conceitos de POO Utilizados

### 🔒 Encapsulamento

Os atributos das classes são privados e acessados por getters e setters.

### 👨‍👩‍👧‍👦 Herança

As classes de denúncia específicas herdam da classe abstrata `Denuncia`.

### 🎭 Polimorfismo

Cada tipo de denúncia possui sua própria implementação de métodos herdados.

### 🏛️ Abstração

A classe `Denuncia` representa uma abstração genérica para todas as denúncias do sistema.

---

## ⚠️ Tratamento de Erros

O sistema realiza validações para evitar operações inválidas.

🚫 Campos obrigatórios vazios

🚫 Protocolos duplicados

🚫 Denúncias inexistentes

🚫 Tipos não selecionados

🚫 Descrições insuficientes

🚫 Dados inconsistentes

Caso ocorra algum erro, o sistema exibirá uma mensagem ao usuário e permitirá uma nova tentativa da operação.

---

## 📂 Estrutura do Projeto

```text
src
│
├── model
│   ├── Denuncia.java
│   ├── DenunciaBullying.java
│   ├── DenunciaAssedio.java
│   ├── DenunciaDiscriminacao.java
│   └── DenunciaVandalismo.java
│
├── service
│   └── DenunciaService.java
│
├── exception
│   ├── CampoObrigatorioException.java
│   ├── DenunciaNaoEncontradaException.java
│   └── ProtocoloDuplicadoException.java
│
├── view
│   ├── TelaPrincipal.java
│   ├── TelaCadastro.java
│   ├── TelaConsulta.java
│   └── TelaListagem.java
│
└── Main.java
```

---

## 🛠️ Tecnologias Utilizadas

☕ Java

🖥️ Java Swing

📂 ArrayList

⚠️ Exceptions

🧠 Programação Orientada a Objetos

---

## 🎯 Objetivo Acadêmico

Este projeto foi desenvolvido com foco no aprendizado de:

- Programação Orientada a Objetos
- Interface Gráfica com Swing
- Estruturação de projetos Java
- Tratamento de exceções
- Boas práticas de desenvolvimento

---

## 🌱 Melhorias Futuras

🗄️ Integração com banco de dados

📎 Anexar evidências

📧 Notificações automáticas

🌐 Versão web

📱 Versão mobile

---

## 👩‍💻 Desenvolvedora

Projeto desenvolvido por Ana Vitória com auxílio de IA generativa para fins acadêmicos e aprendizado de desenvolvimento de software.