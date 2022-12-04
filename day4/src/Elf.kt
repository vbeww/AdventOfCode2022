class Elf(sections: String) {

    private val sections = sections.split("-").map { it.toInt() }
    fun containsSections(otherElf: Elf) = sections[0] <= otherElf.sections[0] && sections[1] >= otherElf.sections[1]
}