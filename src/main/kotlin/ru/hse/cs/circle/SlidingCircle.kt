@file:JvmName("MainKt")
package ru.hse.cs.circle

import javafx.event.EventHandler
import javafx.geometry.Point2D
import javafx.scene.paint.Color
import javafx.util.Duration
import tornadofx.*

class Main : App(SlidingCircle::class)

fun main(args: Array<String>) {
    launch<Main>(args)
}

class SlidingCircle : View() {
    override val root = stackpane {
        minWidth = 600.0
        minHeight = 600.0
        title = "Sliding purple circle"

        val myCircle = circle {
            centerX =  0.0
            centerY = 0.0
            radius = 70.0
            fill = Color.PURPLE
        }

        onMouseMoved = EventHandler {
            myCircle.move(time = Duration(50.0), destination = Point2D(it.x - width / 2, it.y - height / 2))
        }
    }
}