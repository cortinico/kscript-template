#!/usr/bin/env kscript
@file:DependsOn("info.picocli:picocli:4.3.2")

import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import java.io.File
import java.util.concurrent.Callable


@Command(name = "scaffolded-script", mixinStandardHelpOptions = true, version = ["1.0"])
class GenerateSnippets : Callable<Int> {

    private val DEFAULT_INPUT = "."

    @Option(names = ["-f", "--fail"], description = ["Ask the script to fail"])
    private var SHOULD_FAIL: Boolean = false

    @Option(names = ["-i", "--input"], paramLabel = "FOLDER", description = ["The input .yml file to read from"])
    private var INPUT: String = DEFAULT_INPUT

    override fun call(): Int {
        info("📜📜📜 scaffolded-script 📜📜📜", "")
        info("Welcome to scaffolded-script", "👋")
        info("Should run a failure: $SHOULD_FAIL")
        info("Input folder: $INPUT")

        if (SHOULD_FAIL) {
            error("You asked me to fail...", Throwable("User requested failure"), 42)
        }
        if (INPUT == DEFAULT_INPUT) {
            warn("Missing input folder, defaulting to [$DEFAULT_INPUT]")
        }
        info("Printing folder content...")
        File(INPUT).walkTopDown().forEach {
            info(it.path, "➡️")
        }
        succ("Script completed successfully!")
        return 0
    }


    /*
     * DEBUG Prints function
     ******************************************************************/

    fun error(message: String, throwable: Throwable? = null, statusCode: Int = 1): Nothing {
        System.err.println("❌\t${Colors.ANSI_RED}$message${Colors.ANSI_RESET}")
        throwable?.let {
            System.err.print(Colors.ANSI_RED)
            it.printStackTrace()
            System.err.print(Colors.ANSI_RESET)

        }
        System.exit(statusCode)
        throw Error()
    }

    fun warn(message: String) {
        System.out.println("⚠️\t${Colors.ANSI_YELLOW}$message${Colors.ANSI_RESET}")
    }

    fun succ(message: String) {
        System.out.println("✅\t${Colors.ANSI_GREEN}$message${Colors.ANSI_RESET}")
    }

    fun info(message: String, emoji: String = "ℹ️") {
        System.out.println("$emoji\t$message")
    }
}

CommandLine(GenerateSnippets()).execute(*args)

/*
 * ASCII Color
 ******************************************************************/

object Colors {
    val ANSI_RESET = "\u001B[0m"
    val ANSI_BLACK = "\u001B[30m"
    val ANSI_RED = "\u001B[31m"
    val ANSI_GREEN = "\u001B[32m"
    val ANSI_YELLOW = "\u001B[33m"
    val ANSI_BLUE = "\u001B[34m"
    val ANSI_PURPLE = "\u001B[35m"
    val ANSI_CYAN = "\u001B[36m"
    val ANSI_WHITE = "\u001B[37m"
}
