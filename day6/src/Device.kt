class Device(bufferStream: String) {
    val markerPosition = (4..bufferStream.length).first {
        bufferStream.substring((it - 4) until it).toList().distinct().size == 4
    }
}