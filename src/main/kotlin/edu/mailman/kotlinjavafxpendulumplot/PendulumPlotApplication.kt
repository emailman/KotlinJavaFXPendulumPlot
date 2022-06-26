package edu.mailman.kotlinjavafxpendulumplot

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.layout.Pane
import javafx.stage.Stage

import kotlin.math.cos
import kotlin.math.sin

const val xOffset = 0.0
const val yOffset = 0.0

const val pendulumLength = 95
const val startAngle = 252.0

val angleIncrements = arrayOf(0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.4, 4.0,
                                    4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.5)

class PendulumPlotApplication : Application() {

    override fun start(stage: Stage) {

        // Create x-axis and y-axis
        val xAxis = NumberAxis(-50.0, 50.0, 10.0)
        val yAxis = NumberAxis(100.0, 0.0, 0.0)

        // Create a line graph
        val lineChart = LineChart(xAxis, yAxis)

        // Create a data series
        val dataSeries = XYChart.Series<Number, Number>()
        dataSeries.name = "Plot the Path of a Pendulum"

        // Add points to the data series between
        // 250 degrees and 290 degrees
        var currentAngle = startAngle
        for (angleIncrement in angleIncrements) {
            currentAngle += angleIncrement
            println("$currentAngle  $angleIncrement")

            // Calculate the coordinates of the next point
            val x = pendulumLength *
                    cos(Math.toRadians((currentAngle)))
            val y = pendulumLength *
                    sin(Math.toRadians((currentAngle)))

            val dataPoint = offset(x, y)
            val x1 = dataPoint[0]
            val y1 = dataPoint[1]

            // Add the point to the data series
            dataSeries.data.add(XYChart.Data(x1, y1))

        }

        // Add the data series to the graph
        lineChart.data.add(dataSeries)

        // Create a pane and add the graph to it
        val pane = Pane()
        pane.children.add(lineChart)

        // Create a scene and add the pane to it
        val scene = Scene(pane, 500.0, 500.0)

        // Add the scene to the stage
        stage.title = "Pendulum Plot"
        stage.scene = scene
        stage.show()
    }

    private fun offset(x: Double, y: Double): Array<Number> {
        val xOffset = x + xOffset
        val yOffset = -y + yOffset
        return arrayOf(xOffset, yOffset)
    }
}

fun main() {
    Application.launch(PendulumPlotApplication::class.java)
}