# Selenium-Cucumber Automation Framework

Este proyecto es un framework de automatización de pruebas desarrollado en **Java**, utilizando **Selenium WebDriver**, **Cucumber**, **JUnit 5**, y **Jenkins** para CI/CD. Está diseñado para ser fácilmente extensible, ejecutarse de forma local o remota, y generar reportes legibles por humanos en HTML.

---

## 🧱 Estructura del Proyecto

```
.
├── src
│   ├── main
│   │   └── java
│   │       └── config        # Lectura de properties y configuración dinámica
│   │       └── driver        # Manejo del WebDriver con soporte para grid/headless
│   │       └── utils         # Clases auxiliares
│   └── test
│       ├── java
│       │   └── runner        # TestRunner con JUnit Platform
│       │   └── stepdefinitions
│       └── resources
│           └── features      # Archivos .feature de Cucumber
│           └── config        # Archivos .properties para ambientes (qa, prod)
```

---

## 🚀 Características Clave

- ✅ **Automatización UI con Selenium y Cucumber**
- ✅ **JUnit 5 y ejecución paralela con Platform Engine**
- ✅ **Configuración dinámica con archivos `.properties`**
- ✅ **Soporte para Grid Remoto y ejecución en local**
- ✅ **Soporte para ejecución Headless**
- ✅ **Reportes HTML generados con `maven-cucumber-reporting`**
- ✅ **Pipeline CI/CD en Jenkins (con Docker)**
- ✅ **Ambientes separados (`qa`, `prod`)**
- ✅ **Ejecución parametrizada vía `-Denv=qa|prod`**

---

## 🧪 Ejecución de Pruebas

### ✅ Local (Chrome Headless)
```bash
mvn test -Denv=qa
```

### ✅ Grid Remoto (Docker)
```bash
mvn test -Denv=prod
```

> Asegúrate de tener `remote.grid.enabled=true` y una Grid corriendo en Docker (ver más abajo).

---

## 🐳 Docker + Selenium Grid + Jenkins

El archivo `docker-compose.yml` levanta los siguientes servicios:

- `jenkins`: Jenkins con Docker socket montado
- `selenium_chrome`: Contenedor de Selenium con Chrome

Para levantar los contenedores:

```bash
docker-compose up -d
```

---

## 🧪 Generación de Reportes

Luego de ejecutar las pruebas:

```bash
mvn verify
```

Esto generará un reporte HTML en:

```
target/cucumber-report/cucumber-html-reports/overview-features.html
```

---

## 🤖 Jenkins CI/CD Pipeline

### Jenkinsfile incluye los siguientes stages:

1. **Instalar Dependencias** (`mvn clean install -DskipTests`)
2. **Ejecutar Tests** (`mvn test -Denv=prod`)
3. **Generar Reporte** (`mvn verify`)
4. **Publicar Reporte HTML** (HTML Publisher)

> El pipeline corre automáticamente con cada push a `main`.

---

## ⚙️ Variables de Configuración

Se encuentran en `src/test/resources/config/`:

### `config.qa.properties`
```properties
demoqa.base.url=https://demoqa.com
wait.timeout=5
headless=true
remote.grid.enabled=false
```

### `config.prod.properties`
```properties
demoqa.base.url=https://demoqa.com
wait.timeout=5
headless=true
remote.grid.enabled=true
remote.grid.url=http://selenium_chrome:4444/wd/hub
```

Usa `-Denv=qa` o `-Denv=prod` para especificar el entorno en tiempo de ejecución.

---

## 📌 Requisitos Previos

- Java 8+
- Maven
- Docker + Docker Compose (para Grid y Jenkins)
- Git

---

## ✨ Autor

Creado por [Daniel Agudelo](https://github.com/Dagudelot) como parte de la preparación para una entrevista técnica de QA Automation Senior.

---

## 🗓 Última actualización

Julio 2025
