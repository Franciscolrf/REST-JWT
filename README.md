# JWT Auth API (Spring Boot)

Este proyecto es un servicio REST en Spring Boot que implementa autenticación con **JWT (JSON Web Tokens)**. El sistema no utiliza base de datos y tiene un usuario simulado en memoria.

## 🚀 Tecnologías usadas

- Java 17
- Spring Boot 3.4.5
- Spring Security
- jjwt (0.11.5)
- Postman (para pruebas)

---

## 🔐 Funcionalidad

1. **POST /login**
   - Envía un JSON con `username` y `password`.
   - Si las credenciales son correctas (`admin` / `1234`), devuelve un token JWT válido.
   - **Ejemplo de request:**

     ```json
     {
       "username": "admin",
       "password": "1234"
     }
     ```

2. **GET /hello**
   - Endpoint protegido, requiere token JWT válido en el header `Authorization`.
   - Si el token es válido, devuelve un mensaje de éxito.

---

## 🛡️ Seguridad

- Se usa un filtro personalizado (`JwtFilter`) que intercepta las peticiones y valida el token.
- Se configura Spring Security para que `/login` sea público y todo lo demás esté protegido.
- No se utilizan sesiones (stateless API).

---

## 📦 Ejecución

```bash
mvn clean install
mvn spring-boot:run

🧪 Prueba rápida en Postman
POST a http://localhost:8080/login con el body:

{
  "username": "admin",
  "password": "1234"
}

Copia el token devuelto (sin "Bearer " si ya lo pone Postman).

Haz un GET a http://localhost:8080/hello, usando el token en el apartado Authorization → Bearer Token.
