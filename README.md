# AI Voice Agent (Siri-like) for Samsung A34

This project aims to develop a custom AI voice assistant for Android (specifically optimized for Samsung A34) that can handle information retrieval and perform system actions like making phone calls.

## Project Phases

### Phase 1: Research & Architecture
- **Define Capabilities:** Information retrieval, phone calls, reminders, and system controls.
- **Tech Stack Selection:**
    - **Language:** Kotlin (Standard for modern Android).
    - **STT (Speech-to-Text):** Android SpeechRecognizer or Google Cloud STT.
    - **Brain (LLM):** Google Gemini API (via Vertex AI) for natural language understanding.
    - **TTS (Text-to-Speech):** Android TextToSpeech or Google Cloud TTS.
- **UI/UX Design:** Create a minimalist overlay or activity for voice interaction.

### Phase 2: Environment Setup & Authentication
- **Android Studio:** Configure project for API Level 33+ (Android 13/14).
- **Google Cloud/Vertex AI:**
    - Create a GCP Project.
    - Enable Vertex AI API.
    - Generate API Keys or Service Account credentials.
- **Permissions:** Configure `AndroidManifest.xml` for Microphone, Internet, and Call Phone permissions.

### Phase 3: Core Voice Components (STT & TTS)
- **STT Implementation:** Integrate the microphone listener to convert speech to text.
- **TTS Implementation:** Integrate the engine to convert AI responses into audible speech.
- **Trigger Mechanism:** Implement a "Push-to-Talk" button or a simplified wake-word listener.

### Phase 4: AI Logic Integration (The Brain)
- **Gemini API Integration:** Send transcribed text to Gemini.
- **Prompt Engineering:** Define the "Siri" persona and instruction set.
- **Function Calling:** Implement logic to detect when the user wants to "Call someone" or "Search for info".

### Phase 5: Feature Implementation (Actions)
- **Telephony Integration:** Use Android Intents to initiate phone calls.
- **Information Retrieval:** Use Gemini's knowledge base and potentially web search capabilities.
- **System Integration:** Control volume, brightness, or open other apps.

### Phase 6: UI/UX Development
- **Visual Feedback:** Add animations (like Siri's glowing orb) when the agent is listening or processing.
- **History View:** Show a brief chat history for clarity.

### Phase 7: Testing & Optimization
- **Samsung A34 Deployment:** Test directly on the hardware.
- **Latency Tuning:** Optimize API calls for faster response times.
- **Permission Handling:** Ensure graceful handling of denied permissions.

## Getting Started: Prerequisites
1. **Google Cloud Account:** Required for Vertex AI (Gemini).
2. **Android Studio:** Installed and updated.
3. **Samsung A34:** Enabled with Developer Options and USB Debugging.
4. **API Keys:** Securely stored in a `.env` or `secrets.xml` file (not committed to version control).
