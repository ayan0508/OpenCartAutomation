# 🛠️ OpenCart Automation Testing 🚀

## 📌 Project Overview
This automation project tests the **end-to-end workflow** of [demo.opencart.com](https://demo.opencart.com), covering:
- ✅ **User Login**
- ✅ **Product Search & Selection**
- ✅ **Adding Items to Cart**
- ✅ **Checkout Process Validation**

Since the website has **Cloudflare protection**, manual intervention is required to bypass CAPTCHA before executing automated scripts.

---

## ⚙️ Tech Stack
- **Programming Language:** Java  
- **Automation Framework:** Selenium WebDriver  
- **Testing Framework:** TestNG  
- **Build Tool:** Maven  
- **Browser:** Chrome WebDriver  
- **Reporting:** Extent Reports  

---

## 📂 Project Structure

Each folder has a specific purpose:
- **pages/** → Contains reusable Page Object Model classes for UI interaction.
- **utils/** → Includes helper methods such as WebDriver setup, logging, and configurations.
- **constants/** → Stores environment URLs and test data.
- **tests/** → Houses structured test cases for login, cart, and checkout functionality.
- **reports/** → Stores execution results, including Extent Reports and screenshots.

---

## 🔧 Setup & Installation

### ✅ Prerequisites
Make sure you have the following installed:
- 🔹 **Java 17+**
- 🔹 **Maven**
- 🔹 **Selenium WebDriver**
- 🔹 **Chrome WebDriver**

### 🔗 Install Dependencies
Run the following command:
```sh
mvn clean install
