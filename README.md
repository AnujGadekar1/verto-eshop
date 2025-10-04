 
# 🛒 Verto E-Shop — Full-Stack Shopping Cart Application

**Verto E-Shop** is a minimal yet production-grade full-stack e-commerce system built using **Spring Boot (Java)** for the backend and **React + TypeScript (Vite)** for the frontend.

This project was developed as part of the **Verto ASE Coding Challenge**, focusing on clear separation between backend and frontend, clean API design, and effective client-side state management.

---

## 🚀 1. Project Overview

The system demonstrates a complete e-commerce flow:

- Fetching products from a hardcoded catalog (**no database required**)
- Managing cart state on the client side
- Persisting cart items using `localStorage`
- Simulating checkout with an API call to the backend
- Logging the order on the server with total calculation and validation

### 🧩 Architecture Overview
- **Backend (Spring Boot)** — Handles product listing, checkout validation, and order logging.  
- **Frontend (React)** — Manages cart UI, state, and checkout simulation.  
- **Testing (JUnit)** — Validates business logic and API endpoints.

---

## 🧩 2. Features Implemented

### 🖥️ Frontend (React + TypeScript)
- Product grid fetching data from backend `/api/products`
- Add-to-cart functionality with quantity tracking
- Cart overlay with:
  - Real-time quantity updates  
  - Live total calculation  
  - Item removal
- Checkout button that sends data to backend `/api/checkout`
- Toast notifications for user feedback
- Cart persistence via `localStorage`
- Fully responsive design (desktop, tablet, mobile)

### ⚙️ Backend (Spring Boot)
- `/api/products` → Returns hardcoded list of 5 products  
- `/api/checkout` → Accepts cart JSON, validates items, logs order, and returns summary  
- CORS configured for `http://localhost:3000` and `http://localhost:5173`  
- Structured logging for orders  
- Unit + integration tests for service and controller layers

### 🧠 Bonus Features
- Quantity modification directly in the cart  
- Persistent cart across page reloads  
- Real product images (Unsplash/Walmart CDN)  
- UUID-based order IDs for realism  
- Clean, professional UI with animations  

---

## ## 🧰 Tech Stack
- **Frontend:** React, TypeScript, Vite, Context API, Toast System
- **Backend:** Spring Boot (Java 17), Maven, REST APIs
- **Testing:** JUnit 5, MockMvc
- **Tools:** VS Code, Postman


## 🛠️ 3. Setup Instructions (Run Locally)

### 🧩 Prerequisites
- **Java 17+**
- **Node.js 18+**
- **Maven 3.9+**

---

### 🧱 Backend Setup (Spring Boot)

```bash
# Navigate to backend folder
cd backend/verto-shop

# Build and run the Spring Boot server
mvn clean install
mvn spring-boot:run
````

Backend runs at:
👉 [http://localhost:8080](http://localhost:8080)

**Verify:**
Visit [http://localhost:8080/api/products](http://localhost:8080/api/products) — you should see a JSON list of products.

---

### 💻 Frontend Setup (React + Vite + TypeScript)

```bash
# Navigate to frontend folder
cd frontend

# Install dependencies
npm install

# Start development server
npm run dev
```

Frontend runs at:
👉 [http://localhost:5173](http://localhost:5173)

---

## 🧪 4. Running Test Cases

All backend tests use **JUnit 5 + Spring Boot Test**.

```bash
# Inside backend folder
cd backend/verto-shop
mvn test
```

### ✅ Tests Included

| Test Class                          | Purpose                                     |
| ----------------------------------- | ------------------------------------------- |
| `ProductServiceTest`                | Verifies hardcoded catalog & product lookup |
| `CheckoutControllerIntegrationTest` | Tests checkout validation, merging & total  |
| `VertoShopApplicationTests`         | Ensures full application context loads      |

**Expected Output:**
✔ All tests should pass → `BUILD SUCCESS`

---

## 💡 5. Design Choices & Assumptions

1. **No Database (per challenge)**
   Products are hardcoded in-memory via `ProductService`.

2. **Separation of Concerns**

   * Backend → APIs & validation
   * Frontend → State & UI management

3. **Local Cart Management**
   React Context + `localStorage` for persistence.

4. **Image URLs**
   Real images from trusted CDNs (Unsplash, Walmart).

5. **Checkout Simulation**
   Backend logs structured JSON of every order.

6. **Testing Approach**
   Integration and service tests ensure reliable API behavior.

---

## 🏗️ 6. System Architecture Overview

### 🧠 High-Level Flow

1. **Frontend (React)** → Fetches `/api/products` → Displays product grid
2. User adds items → Cart updates locally and syncs to `localStorage`
3. Checkout → Sends `POST /api/checkout` with cart JSON
4. **Backend (Spring Boot)** → Validates, calculates totals, logs order, and returns response

---

## 🧩 7. UML Diagrams

### 🧱 a. System Architecture Diagram

Shows high-level interaction between User → Frontend → Backend → In-memory data.

<img width="2076" height="1166" alt="mermaid-diagram-2025-10-04-021852" src="https://github.com/user-attachments/assets/99854275-1d5c-4c6d-8d0b-9b9b23921c2c" />


### 🔁 b. Sequence Diagram

Illustrates the complete checkout flow and request-response cycle.

<img width="3840" height="2463" alt="Sequence-Shop-Cart" src="https://github.com/user-attachments/assets/01a5ce24-b4d9-4db1-9587-b0e5241ea8e3" />


### ⚙️ c. Component Diagram

Depicts React components (CartContext, APIService) and Spring modules (Controllers, Services, Models).

<img width="981" height="623" alt="c" src="https://github.com/user-attachments/assets/bd0571b9-bc37-435c-8e53-329fcd988ea8" />


> 📁 Diagrams are included in `/diagrams/` folder.


### Preview Screenshot:

### 1.
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/0f91ed25-f1f3-497e-9c4d-38d8a37edd77" />

### 2.
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/5dfe1ec7-1f02-4486-92bb-1b731c55cfec" />

### 3.
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/14524c23-3f8c-42de-8d44-31b9974583fd" />

### 4.
<img width="1368" height="139" alt="image" src="https://github.com/user-attachments/assets/63565b23-bfd3-405d-8f38-2388ebd3ea24" />

### 5.
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/28943863-7e95-4469-91c9-fc4c54327164" />



---

## 🌍 8. Deployment & Scaling (Beyond the Challenge)

While this fulfills all **Verto ASE Challenge** requirements, here’s how we’d make it production-ready:

### 🚀 Step 1 — Containerization

* Dockerize frontend and backend
* Use `docker-compose` for combined orchestration

### ☁️ Step 2 — Cloud Deployment

* Backend → AWS Elastic Beanstalk / Render
* Frontend → Netlify / Vercel

### 🗄️ Step 3 — Database Integration

* Add PostgreSQL or MongoDB for product/order persistence
* Integrate JPA/Hibernate ORM layer

### ⚖️ Step 4 — Scaling the System

* Horizontal scaling with NGINX or AWS Load Balancer
* Redis caching for product data
* CDN for static assets and images
* JWT-based user authentication
* CI/CD pipeline via GitHub Actions

---

## 🧾 9. Summary

| Category             | Implementation                                          |
| -------------------- | ------------------------------------------------------- |
| **Frontend**         | React + TypeScript + Context API + Toast + LocalStorage |
| **Backend**          | Spring Boot + Validation + Logger + UUID Orders + CORS  |
| **Testing**          | JUnit + MockMvc + Integration + Unit Tests              |
| **Deployment Ready** | Modular, scalable, and production-extendable            |

---

## 👨‍💻 Author

**Anuj Gadekar**
 
