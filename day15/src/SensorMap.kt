class SensorMap(exampleInput: String) {
    private val sensors = exampleInput.split("\n").map { sensorInput ->
        sensorInput.replace("Sensor at x=", "")
                .replace(" y=", "")
                .replace(": closest beacon is at x=", ",")
                .split(",")
                .map { it.toInt() }
                .let { Sensor(it[0] to it[1], it[2] to it[3]) }
    }


    fun freeSpotInArea(size: Int): Long {
        var beacon = 0 to 0
        do {
            val newSpot = sensors.fold ( beacon ) { possibleSpot, sensor ->
                sensor.suggestNewSpot(possibleSpot, size)
            }
            val changed = newSpot != beacon
            beacon = newSpot
        } while (changed)
        return 4_000_000L * beacon.first + beacon.second
    }
}
