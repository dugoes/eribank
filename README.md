# eribank

### Configuração:
* Instalar a IDE de preferência
* Fazer o download e instalar o **Android Studio**
* Inserir a variável de ambiente **ANDROID_HOME**
  * Ex: "C:\Users\User\AppData\Local\Android\Sdk"
* Fazer o download e instalar o **Java JDK 8**
* Inserir a variável de ambiente **JAVA_HOME**
  * Ex: "C:\Program Files\Java\jdk1.8.0_291"
* Fazer o download e instalar o **Maven**
* Inserir a variável de ambiente **mvn**
  * Ex: "C:\Tools\apache-maven-3.8.1\bin"
* Editar a variável de ambiente **Path** inserindo 
  * %ANDROID_HOME%\platform-tools
  * %ANDROID_HOME%\tools
  * %ANDROID_HOME%\tools\lib
  * %ANDROID_HOME%\tools\bin
  * %JAVA_HOME%
  * %mvn%
* Fazer o download e instalar o Appium

### Execução
* Baixar o projeto **eribank**
* Abrir o **Android Studio** e selecionar **Configurações > AVD Manager**
* Configurar o Virtual Device conforme abaixo:

  Device    | Release Name | API Level  | Target       
  ------    | ------------ | ---------  | ------
  Pixel 2   | Q            | 29         | Android 10.0

* Ligar o dispositivo
* Instalar no device o app "EriBank.apk" (está na raiz do projeto)
* Abrir o projeto **eribank**
* Procurar o arquivo **suitTest.xml** clicar com o botão direito e selecionar a opção **Run**
