class Device(bufferStream: String) {
    val messageMarkerPosition = findMarker(bufferStream, 14)
    val packetMarkerPosition = findMarker(bufferStream, 4)

    private fun findMarker(bufferStream: String, size: Int): Int {
        return (size..bufferStream.length).first {
            bufferStream.substring((it - size) until it).toList().distinct().size == size
        }
    }
}