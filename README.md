# ARQUITECTURA C4 - Consulta ANT / SRI / Vehículos

Este proyecto es una aplicación web desarrollada con **React** (frontend) y **Spring Boot** (backend) que permite consultar información de:  

- Puntos del **ANT** (Agencia Nacional de Tránsito)  
- Contribuyentes del **SRI** (Servicio de Rentas Internas)
- Informacion de contribuyente **SRI** 
- Información de **vehículos** mediante la placa  

La aplicación utiliza APIs públicas del SRI y ANT para obtener los datos y los muestra de manera organizada en la interfaz.

---

## Funcionalidades

1. **Consultar Puntos ANT**  
   - Ingresar la cédula y obtener los puntos de tránsito.  

2. **Verificar si es contribuyente SRI**  
   - Ingresar un RUC y verificar si es contribuyente (`Sí` o `No`).  

3. **Información detallada del contribuyente SRI**  
   - Ingresar un RUC y obtener:  
     - Razón Social  
     - Estado  
     - Actividad Económica Principal  
     - Tipo de Contribuyente  
     - Fecha de inicio de actividades  

4. **Consultar información de vehículos**  
   - Ingresar la placa y obtener:  
     - Placa  
     - Marca  
     - Modelo  

---

## Requisitos

- **Java 17+** (para Spring Boot)  
- **Maven** (para dependencias backend)  
- **Node.js 18+** y **npm** (para React frontend)  

---

## Instalación y ejecución
1. Entrar a la carpeta backend (donde está pom.xml).
2. Construir el proyecto en la terminal:
   mvn clean install
4. Ejecutar la aplicacion
   mvn spring-boot:run

# Apartado Frontend
1. Entrar a la carpeta frontend (donde está package.json).
2. Instalar dependencias:
   npm install
3. Ejecutar
   npm run dev
Por defecto se abrirá en http://localhost:5173.

NOTA: Asegurarse de que el backend esté corriendo antes de hacer consultas desde el frontend.

### Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_PROYECTO>

