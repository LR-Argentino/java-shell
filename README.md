# Simple Java Shell

<img src="https://github.com/user-attachments/assets/ca3ad26e-0f33-4dfa-a868-9b7ac5df42c7" alt="coding" width="400">

Die **Simple Java Shell** ist eine in Java implementierte Shell, die grundlegende Funktionen einer Kommandozeile bietet. Aktuell unterstützt die Shell sowohl **builtin-Befehle** wie `echo`, `pwd`, `type` und `exit`. Auch die Ausführung von **externen Befehlen** wie `ls`, `git` oder anderen ausführbaren Programmen, die im `PATH`-Umgebungsvariablenpfad verfügbar sind, sollte sie untertützen (externe Befehle sind noch in Bearbeitung).

Dieses Projekt ist **noch in der Entwicklung** und dient als Übung für das Verständnis und die Umsetzung von Shell-Funktionalitäten in einer Java-Umgebung. Es folgen noch viele geplante Features und Optimierungen, um die Shell leistungsfähiger und benutzerfreundlicher zu machen.

### Features:
- **Builtin-Befehle:**
  - `echo`: Gibt Text auf der Konsole aus.
  - `pwd`: Zeigt das aktuelle Arbeitsverzeichnis an.
  - `exit`: Beendet die Shell.
  
- **Unterstützung von externen Befehlen (⚠️ noch in umsetzung ⚠️):**
  - Führt Programme aus, die im `PATH`-Verzeichnis verfügbar sind (z. B. `ls`, `git`).

- **Modularer Aufbau:**
  - Trennung von Kernkomponenten wie `Shell`, `Executor`, `CommandManager` und `ExecutableFinder`.
  - Leicht erweiterbare Architektur für zusätzliche Befehle.

- **Abstrakte Schnittstellen:**
  - Verwendung von Interfaces (`CommandService`, `ExecutorService`, etc.) für bessere Testbarkeit und Erweiterbarkeit.
 
  ### Geplante Verbesserungen:
1. **Caching von externen Befehlen:**
   - Reduziert Dateisystemzugriffe, indem häufig verwendete externe Befehle zwischengespeichert werden.
   
2. **Fehlerbehandlung:**
   - Verbesserte Verarbeitung von ungültigen Eingaben und fehlerhaften Befehlen.
   - Benutzerfreundlichere Fehlermeldungen.

3. **Logging:**
   - Einfache Log-Ausgaben zur Nachverfolgung der Befehlsausführung und Fehler.

4. **Pipeline-Unterstützung:**
   - Unterstützung von Shell-Funktionalitäten wie `ls | grep txt`, um den Output eines Befehls an einen anderen zu übergeben.

5. **Erweiterte Eingabeverarbeitung:**
   - Unterstützung für erweiterte Befehlsparameter und Konfigurationsoptionen.

6. **Tests und Dokumentation:**
   - Umfangreiche Unit-Tests zur Sicherstellung der Stabilität.
   - Eine klare Dokumentation für Entwickler und Nutzer.

7. **Benutzerdefinierte Umgebungsvariablen:**
   - Unterstützung für die Konfiguration und Anpassung von Umgebungsvariablen innerhalb der Shell.
