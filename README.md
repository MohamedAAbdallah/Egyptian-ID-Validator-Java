# Egyptian ID Validator (Java)

<!-- Badges to be tested after going public
[![Latest Tag](https://img.shields.io/github/v/tag/MohamedAAbdallah/Egyptian-ID-Validator-Java?label=latest%20tag)](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/tags)
[![Maven Package](https://img.shields.io/maven-central/v/com.mohamedaabdallah/egyptian-id-validator?label=maven)](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/packages)
[![Build Status](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/actions/workflows/maven.yml/badge.svg)](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/actions/workflows/maven.yml)
[![License](https://img.shields.io/badge/license-MIT--Custom-blue)](LICENSE.md)
[![Last Commit](https://img.shields.io/github/last-commit/MohamedAAbdallah/Egyptian-ID-Validator-Java)](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/commits/main)
-->
---

**Egyptian ID Validator** is a production-ready Java library for validating and extracting structured data from Egyptian national ID numbers.  
It strictly adheres to the official format defined by the Egyptian Ministry of Interior, including a verified but undisclosed checksum algorithm.

> ℹ️ This package is part of a broader multi-language validation system.  
> For other implementations (e.g., Python, NPM), see the [Egyptian-ID-Validator](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator) mother repository.

---

## 🔍 Features

- ✅ **Format Validation** – Ensures the ID is 14 digits and correctly structured.
- ✅ **Checksum Validation** – Verifies integrity using an official checksum method.
- ✅ **Component Extraction** – Parses the ID into:
  - Year, Month, and Day of Birth
  - Governorate Name and Code
  - Gender (Male/Female)

---

## 📦 Installation

To use the library via GitHub Packages, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>com.mohamedaabdallah</groupId>
  <artifactId>egyptian-id-validator</artifactId>
  <version>1.1.3</version>
</dependency>
````

Then run:

```bash
mvn install
```

> ☝️ GitHub authentication is required in your `~/.m2/settings.xml`.
> See: [GitHub Packages – Maven Registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)

---

## 🚀 Quick Usage

```java
import com.mohamedaabdallah.egyptianid.EgyptianIDValidator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String id = "29801010100012";

        Map<String, String> result = EgyptianIDValidator.validate(id);

        if (result != null) {
            System.out.println("✅ Valid Egyptian ID:");
            result.forEach((key, value) -> System.out.println(key + ": " + value));
        } else {
            System.out.println("❌ Invalid ID.");
        }
    }
}
```

**Expected output:**

```
✅ Valid Egyptian ID:
Year: 1998
Month: 01
Day: 01
Governorate: Cairo
Gender: M
```

---

## 📁 Project Status

* Stable and production-ready
* Fully unit-tested and versioned
* Live on GitHub Maven Packages
* Designed for integration in enterprise systems, forms, and ID checks

---

## 🤝 Contributing

Contributions are welcome — especially for:
* Bug reports
* Feature suggestions
* Language porting alignment

Please use [Issues](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/issues) and [Pull Requests](https://github.com/MohamedAAbdallah/Egyptian-ID-Validator-Java/pulls).

---

## 📄 License

This project is licensed under a custom [MIT License with Limited Commercial Use Restrictions](LICENSE.md).

You are free to use, modify, and integrate the package — including in commercial projects — **as long as**:
- You provide proper attribution
- You do **not** sell, sublicense, or rely on this package as the **core functionality** or **main value** of a monetized product or service without prior permission

See the [LICENSE.md](LICENSE.md) file for full terms.

---

## 👤 Author

**Mohamed A. Abdallah**

[GitHub](https://github.com/MohamedAAbdallah) | [Email](mailto:eng.mohamed.a.abdallah@gmail.com)
