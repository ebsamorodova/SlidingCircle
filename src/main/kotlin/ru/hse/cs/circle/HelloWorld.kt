package ru.hse.cs.circle

import javafx.event.EventHandler
import javafx.geometry.Point2D
import javafx.scene.paint.Color
import javafx.util.Duration
import tornadofx.*

class Main : App(HelloWorld::class) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch<Main>(args)
        }
    }
}

class HelloWorld : View() {
    override val root = stackpane {
        minWidth = 500.0
        minHeight = 500.0
        title = "Sliding purple circle"

        val myCircle = circle {
            centerX =  0.0
            centerY = 0.0
            radius = 50.0
            fill = Color.PURPLE
        }

        onMouseMoved = EventHandler {
            myCircle.move(time = Duration(50.0), destination = Point2D(it.x - width / 2, it.y - height / 2))
        }
    }
}