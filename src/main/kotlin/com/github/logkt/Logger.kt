package com.github.logkt

import kotlinx.coroutines.*

class Logger(val name: String, var level: Level = Level.ERROR) {
    private var job: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    fun open() {
        job = scope.launch { run() }
    }

    private fun run(): Job {
        return scope.launch {
            while (isActive) {
                try {
                    // logger logic
                } catch (error: Error) {
                    // handle errors
                }
            }
        }
    }

    fun close() {
        job?.cancel() // Cancel the coroutine
    }
}