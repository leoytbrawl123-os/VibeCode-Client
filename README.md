# VibeCode Client — Minecraft 1.21.11

A starter Fabric client project with a custom ClickGUI foundation.

## Included
- Minecraft Java 1.21.11 target
- Java 21 and Fabric
- Custom dark ClickGUI with cyan accents
- Right mouse button as the default GUI key
- A demonstration toggle row

## Build the JAR online with GitHub Actions
1. Create a new repository on GitHub.
2. Upload the **contents** of this ZIP into the repository (the `build.gradle` file should be at the repository root).
3. Open the repository's **Actions** tab.
4. Select **Build VibeCode Client**, then choose **Run workflow**. A push to `main` or `master` also starts a build.
5. When the run finishes, open it and download the `VibeCode-Client-1.21.11` artifact. The mod JAR is inside the downloaded artifact ZIP.

The workflow uses Java 21, Gradle, and GitHub Actions to compile the project and upload `build/libs/*.jar`. GitHub documents this Gradle workflow approach in its Java/Gradle Actions guide.

## Local build
With JDK 21 and Gradle installed, run:

```bash
gradle build
```

The JAR will be in `build/libs/`.

## Current scope
This is the initial GUI/client foundation. It does not yet contain the full feature set or a tested release build. The source should be built by the workflow before installing it in Minecraft.
