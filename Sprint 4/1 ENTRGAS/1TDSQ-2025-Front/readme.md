# 🚆 ViaSmart — Sistema Integrado de Transporte

O projeto **ViaSmart** consiste em uma solução completa para sistemas de transporte urbano, composta por:

- 🖥️ **Sistema Web Administrativo** (Site)
- 🖲️ **Totem Interativo** (Consulta de Rotas)

As duas aplicações se comunicam com uma **API desenvolvida em Java com Quarkus**, responsável pela lógica de rotas, cadastro de usuários, dúvidas frequentes e controle de permissões.

---

## 📁 Repositórios do Projeto

| Módulo | Descrição | Link |
|--------|-----------|------|
| 🔧 **API Java Quarkus** | Backend com controle de rotas, usuários, dúvidas, autenticação | [Acesse o repositório](https://github.com/MatheusHenriqueNF/API-ViaSmart) |
| 🌐 **Site Administrativo** | Sistema completo para gerenciamento (usuários, dúvidas, permissões) | [Repositório do Site](https://github.com/MatheusHenriqueNF/Site-Sprint-4) |
| 🖲️ **Totem Web** | Interface simples e interativa para terminais públicos | [Repositório do Totem](https://github.com/MatheusHenriqueNF/Totem-Sprint-4) |

---

## 🚀 Como executar localmente

### 📦 1. Clonar os repositórios

```bash
# Clone o site
git clone https://github.com/MatheusHenriqueNF/Site-Sprint-4

# Clone o totem
git clone https://github.com/MatheusHenriqueNF/Totem-Sprint-4

# Clone da api
git clone https://github.com/MatheusHenriqueNF/Java-Sprint-4
````

### 📡 2. Executar a API Java com Quarkus

> O backend é necessário para o funcionamento de **ambos os projetos** (site e totem).

#### Pré-requisitos:

* [Java 17+](https://adoptium.net/)
* [Maven](https://maven.apache.org/)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) (com plugin [Quarkus](https://plugins.jetbrains.com/plugin/13244-quarkus-tools))

---

### 💡 Instalar o plugin do Quarkus no IntelliJ

1. Abra o IntelliJ IDEA
2. Vá até `File > Settings > Plugins`

 ![image](https://github.com/user-attachments/assets/705c1ef7-0dcf-4afe-8241-1f0292099a5b)

3. Busque por **Quarkus** no Marketplace

![image](https://github.com/user-attachments/assets/6ec2b20b-3477-42e2-af0d-ac8b68856ed3)


4. Clique em **Install**
5. Reinicie o IntelliJ após a instalação

---

### 🚀 Executar a API no IntelliJ

1. **Importe o projeto:**

   * Vá em `File > Open` e selecione a pasta do projeto da API Java
   * O IntelliJ reconhecerá o projeto Maven automaticamente

  ![image](https://github.com/user-attachments/assets/cd72b62a-3bcf-4872-89d4-b97cc87ab498)


2. **Verifique o arquivo `pom.xml`:**

   * Certifique-se de que todas as dependências estão resolvidas (ícone verde no canto superior direito)

3. **Configure as variáveis de ambiente (se necessário):**

   * Como `QUARKUS_DATASOURCE_USERNAME`, `QUARKUS_DATASOURCE_PASSWORD` e `QUARKUS_DATASOURCE_JDBC_URL`
   * Isso pode ser feito dentro da aba `Edit Configurations` > `Application` > `Environment variables`

4. **Execute a API pelo RUN:**

   * RUN > Selecione o run com Quarkus

![image](https://github.com/user-attachments/assets/f5e56bd9-ce26-4488-a7ff-43ecf77d3d8e)


5. **Execute a API pelo TERMINAL:**

   * TERMINAL > Digite:  mvn quarkus:dev
   * ⚠️ Verifique se está no diretório correto, caso execute o código fora do repositória da API não irá funcionar

6. **A API estará disponível em:**

   ```
   http://localhost:8080
   ```

---

### 📌 Endpoints úteis

* **Login:** `POST http://localhost:8080/login`
* **Listar estações:** `GET http://localhost:8080/estacoes-linhas`
* **Dúvidas frequentes:** `GET http://localhost:8080/duvidas`

> Garanta que o CORS está habilitado no projeto Quarkus (`application.properties`):

```properties
quarkus.http.cors=true
```
---

## 🔌 Integração com a API

> ⚠️ O totem consome endpoints da **API Java com Quarkus**. Certifique-se de que a API esteja rodando localmente (porta 8080 por padrão) ou altere os endpoints do frontend para apontar para uma URL pública com CORS liberado.

Exemplo de endpoint usado:

```http
GET http://localhost:8080/rota?origem=SÉ&destino=LAPA
```

### ⚙️ Alterando a URL da API

A URL da API pode ser alterada nos arquivos de `fetch()` localizados nos componentes que consomem a API.

---


## 🌐 Site Administrativo

### ⚙️ Como rodar:

```bash
cd Site-Sprint-4
npm install
npm run dev
```

> Acesse: [http://localhost:3000](http://localhost:3000)

### 🔐 Como logar

| Cargo                  | Usuário   | Senha    |
| ---------------------- | --------- | -------- |
| Engenheiro de Sistemas | `ES@5948` | `193420` |
| Controlador de Tráfego | `CT@4078` | `496305` |

> Credenciais são para fins de demonstração e devem existir no banco da API.

### 🧩 Funcionalidades:

* Gerenciamento completo de usuários
* Permissões por cargo
* Cadastro e atualização de dúvidas
* Visualização e controle de linhas e estações

---

## 🖲️ Totem Interativo

### ⚙️ Como rodar:

```bash
cd Totem-Sprint-4
npm install
npm run dev
```

> Acesse: [http://localhost:3000](http://localhost:3000)

### ✨ Funcionalidades:

* Consulta de rota entre estações (com visual estilo linha do tempo)
* Dúvidas frequentes com expansão ao clicar
* Inatividade: retorna à tela inicial após 15 segundos sem interação

---

## 🔌 Integração com a API

Ambos os projetos fazem chamadas a `http://localhost:8080`, onde a API Java deve estar em execução.

### 🔧 Para Deploy:

* A API **deve estar em um servidor público com CORS liberado**
* Altere os endpoints no código dos projetos (`fetch('http://localhost:8080/...')`) para a nova URL pública

---

## ☁️ Deploy (opcional)

Você pode fazer deploy do **site** utilizando a https://vercel.com/matheus-freitas-projects-364d2ef3/site-sprint-4-xcep.


Você pode fazer deploy do **totem** utilizando a https://vercel.com/matheus-freitas-projects-364d2ef3/totem-sprint-4-xmx4

### CLI:

```bash
npm install -g vercel
vercel
```

---

## 🧠 Tecnologias utilizadas

* **Front-end**: Next.js, React, TypeScript, Tailwind CSS
* **Back-end**: Java, Quarkus, Oracle DB
* **Outros**: Vercel (Hospedagem), IntelliJ IDEA

---
## ⚠️ Observações importantes

* Caso a **API esteja rodando localmente**, o Vercel **não conseguirá acessá-la**.

---

# 📺 ACESSE O REPOSITÓRIO DAS APLICAÇÕES
* ACESSE TAMBÉM O SITE DESENVOLVIDO AQUI: https://github.com/MatheusHenriqueNF/Site-Sprint-4
* ACESSE TAMBÉM O TOTEM DESENVOLVIDO AQUI: https://github.com/MatheusHenriqueNF/Totem-Sprint-4
* ACESSE TAMBÉM A API DESENVOLVIDA AQUI: https://github.com/MatheusHenriqueNF/Java-Sprint-4
---

# 🚨 VÍDEO DA APLICAÇÃO
* Vídeo no YouTube: https://www.youtube.com/watch?v=rPb_e6c50GM

## 👨‍💻 Integrantes

* **CLEYTON ENRIKE DE OLIVEIRA** – RM 560485 (1TDSQ)
* **MATHEUS HENRIQUE NASCIMENTO DE FREITAS** – RM 560442 (1TDSQ)
* **MATHEUS PINHEIRO ERMACORA MARTIN** – RM 557720 (1TDSZ)

---

## ✅ Status

✅ Projeto Finalizado — **Sprint 4 FIAP 2025**
🧪 Testado com dados reais de simulação
📎 Suporte a múltiplos perfis de usuário
🛰️ Integração full stack com persistência em banco Oracle

