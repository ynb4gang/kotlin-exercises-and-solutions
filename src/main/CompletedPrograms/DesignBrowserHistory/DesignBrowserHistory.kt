package DesignBrowserHistory

import kotlin.math.max
import kotlin.math.min

fun main() {
    // Создаем объект BrowserHistory с домашней страницей "https://www.example.com"
    val browserHistory = BrowserHistory("https://leetcode.com")

    // Посещаем несколько URL-ов
    browserHistory.visit("https://google.com")
    browserHistory.visit("https://facebook.com")
    browserHistory.visit("https://beatstars.com")

    // Выводим историю после посещения нескольких URL-ов
    println("Full History: ${browserHistory.history}")

    // Возвращаемся на несколько шагов назад и выводим текущий URL
    val backSteps = 2
    val backUrl = browserHistory.back(backSteps)
    println("Back $backSteps steps. Current URL: $backUrl")

    // Переходим вперед на несколько шагов и выводим текущий URL
    val forwardSteps = 1
    val forwardUrl = browserHistory.forward(forwardSteps)
    println("Forward $forwardSteps steps. Current URL: $forwardUrl")
}


internal class BrowserHistory(homepage: String) {
    var history: MutableList<String>
    private val urlIndexMap: MutableMap<String, Int>
    private var currentUrl: Int

    init {
        history = ArrayList()
        urlIndexMap = HashMap()
        history.add(homepage)
        urlIndexMap[homepage] = 0
        currentUrl = 0
    }

    fun visit(url: String) {
        history.subList(currentUrl + 1, history.size).clear()
        history.add(url)
        currentUrl = history.size - 1
        urlIndexMap[url] = currentUrl
    }

    fun back(steps: Int): String {
        val n = currentUrl - steps
        currentUrl = max(n.toDouble(), 0.0).toInt()
        return history[currentUrl]
    }

    fun forward(steps: Int): String {
        val n = currentUrl + steps
        currentUrl = min(n.toDouble(), (history.size - 1).toDouble()).toInt()
        return history[currentUrl]
    }
}

