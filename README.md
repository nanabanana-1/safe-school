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
## 📋 Requisitos Funcionais

RF01 - O sistema deve permitir o cadastro de denúncias escolares.

RF02 - O sistema deve gerar um protocolo único para cada denúncia.

RF03 - O sistema deve permitir consultar denúncias pelo protocolo.

RF04 - O sistema deve listar todas as denúncias cadastradas.

RF05 - O sistema deve permitir atualizar o status de uma denúncia.

RF06 - O sistema deve permitir encerrar denúncias.

RF07 - O sistema deve permitir registrar diferentes tipos de denúncia.

RF08 - O sistema deve exibir informações detalhadas da denúncia.

RF09 - O sistema deve informar ao usuário quando uma operação for realizada com sucesso.

RF10 - O sistema deve funcionar por meio de interface gráfica.

---

## ⚙️ Requisitos Não Funcionais

RNF01 - O sistema deve ser desenvolvido na linguagem Java.

RNF02 - O sistema deve utilizar Programação Orientada a Objetos.

RNF03 - O sistema deve implementar encapsulamento.

RNF04 - O sistema deve implementar herança.

RNF05 - O sistema deve implementar polimorfismo.

RNF06 - O sistema deve implementar abstração.

RNF07 - O sistema deve utilizar tratamento de exceções.

RNF08 - O sistema não deve utilizar banco de dados.

RNF09 - Os dados devem ser armazenados em memória utilizando ArrayList.

RNF10 - A interface gráfica deve ser desenvolvida com Java Swing.

RNF11 - O sistema deve apresentar mensagens de erro amigáveis ao usuário.

RNF12 - O sistema deve continuar funcionando após erros de entrada, permitindo nova tentativa da operação.

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