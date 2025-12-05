# Dieses Programm dient dazu Passwörter auf ihre Sicherheit zu überprüfen und sichere Passwörter zu erstellen

### Folgenden Kriterien müssen erfüllt sein:

- mindestens eine Ziffer
- mindestens ein Großbuchstabe
- mindestens ein Kleinbuchstabe
- mindestens ein Sonderzeichen
- mindestens 8 Zeichen
- nicht in einer Liste mit häufigen/schwachen Passwörtern

##### Es wurde auf Regex verzichtet, um Schleifen und Arrays zu üben.

#### Mit der Main-Funktion kann ein Passwort Validiert werden.

#### Mit der generateSecurePassword-Funktion wir ein Passwort generiert, dass alle Kriterien erfüllt mit einer Länge, die selbst zu wählen ist.

#### Build/Run/Test wurde mit *mvn clean verify* und *mvn package* durchgeführt. Die .jar ist unter /target/classes zu finden.