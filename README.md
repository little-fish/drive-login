# kodi-login

## OneDrive

https://learn.microsoft.com/en-us/onedrive/developer/rest-api/getting-started/graph-oauth?view=odsp-graph-online

https://learn.microsoft.com/en-us/entra/identity-platform/v2-oauth2-auth-code-flow

https://forum.kodi.tv/showthread.php?tid=228443

https://github.com/cguZZman/plugin.onedrive

https://github.com/cguZZman/drive-login


## Deploy with GitHub Actions

https://fly.io/docs/app-guides/continuous-deployment-with-github-actions/

https://docs.github.com/en/actions/security-guides/automatic-token-authentication

https://github.com/docker/login-action?tab=readme-ov-file#github-container-registry

## Native image

When building a native image and getting the following error:

```
Error: Default native-compiler executable 'cl.exe' not found via environment variable PATH
```

See the [cl.exe missing when building native app using GraalVM](https://stackoverflow.com/questions/64197329/cl-exe-missing-when-building-native-app-using-graalvm). All you have to do is to launch the build from _Native Tool Command Prompt_, or modify `native-image.cmd`.
