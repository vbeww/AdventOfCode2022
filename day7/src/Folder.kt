class Folder(private val name: String, private val size: Long, private val subFolders: List<Folder>) {
    var totalSize: Long = subFolders.map { it.totalSize }.sum() + size
}