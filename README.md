# kscript-template 📜

[![Use this template](https://img.shields.io/badge/from-kscript--template-brightgreen?logo=dropbox)](https://github.com/cortinico/kscript-template/generate) ![Run Script](https://github.com/cortinico/kscript-template/workflows/Run%20Script/badge.svg) ![License](https://img.shields.io/github/license/cortinico/kscript-template.svg) ![Language](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template?color=blue&logo=kotlin)

A simple Github template that lets you create a [**kscript**](https://github.com/holgerbrandl/kscript) repository ready to run and share in a **few seconds**. 

## How to use  👣

Just click on [![Use this template](https://img.shields.io/badge/-Use%20this%20template-brightgreen)](https://github.com/cortinico/kscript-template/generate) button to create a new repo starting from this template.

Once created don't forget to update the:
- [Script name](scaffolded-script.kts) both the filename and the occurrencies inside the script.
- The script name inside the Github Actions [workflow file](.github/workflows/run-script.yaml).

The templated script is just printing the list of files from a input directory. You can use this as a starting point to create your script around it:

<p align="center">
    <img src="https://imgur.com/zi5CjIs.png" width="80%">
</p>

## Features 🎨

- Cli Args parsing with [picocli](https://github.com/remkop/picocli/).
- Logging functions `info`, `warn`, `error`, `success` with emoji support ✅⚠️❌.
- Support for ASCII colored output 🎨.
- CI Setup with GitHub Actions.
- Publishing of bundled artifact out of the box.
- Issues Template (bug report + feature request).
- Pull Request Template.

## CLI Args ⌨️

This project is using [picocli](https://github.com/remkop/picocli/) to easily parse the CLI Options and Parameters. You can find more example on how to set up the flags on the [official documentation page](https://picocli.info/#_introduction).

You can use the `--help` flag to get a nice report for the available flags:

<p align="center">
    <img src="https://imgur.com/KS6KtoV.png" width="80%">
</p>

If you want to see how a failure looks like, invoke with `--fail` or `-f`:

<p align="center">
    <img src="https://imgur.com/BYn1OxI.png" width="80%">
</p>

## Logging 📣

A couple of util functions are available for logging:
* ℹ️ `info` to report a info message. You can optionally provide an emoji to enrich the log.
* ✅ `succ` to report a green success message.
* ⚠️ `warn` to report a yellow warning message.
* ❌ `error` to report an error. Optionally you can provide also:
    - A `Throwable` that will be logged on the screen
    - An exit code `Int`. If not provided the default is `1`

Calling `error` will also stop the script.

## CI ⚙️

This template is using [**GitHub Actions**](https://github.com/cortinico/kscript-template/actions) as CI. You don't need to setup any external service and you should have a running CI once you start using this template.

The workflow [Run Script](https://github.com/cortinico/kscript-template/actions?query=workflow%3A%22Run+Script%22) will take care of running the script and publishing the bundled version of it as an artifact (users can easily download it).

## Contributing 🤝

Feel free to open a issue or submit a pull request for any bugs/improvements.