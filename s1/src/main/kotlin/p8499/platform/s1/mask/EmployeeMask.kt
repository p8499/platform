package p8499.platform.s1.mask

class EmployeeMask(origin: String) {
    val raw: StringBuilder = StringBuilder().apply {
        when {
            origin.length > 5 -> origin.substring(0, 5)
            origin.length < 5 -> origin.padEnd(5, '0')
            else -> origin
        }.forEachIndexed { index, c -> append(if (c == '1') '1' else '0') }
    }
    var emid: Boolean
        set(value) = raw.setCharAt(0, if (value) '1' else '0')
        get() = raw[0] == '1'
    var emstatus: Boolean
        set(value) = raw.setCharAt(1, if (value) '1' else '0')
        get() = raw[1] == '1'
    var emgender: Boolean
        set(value) = raw.setCharAt(2, if (value) '1' else '0')
        get() = raw[2] == '1'
    var emname: Boolean
        set(value) = raw.setCharAt(3, if (value) '1' else '0')
        get() = raw[3] == '1'
    var embirthday: Boolean
        set(value) = raw.setCharAt(4, if (value) '1' else '0')
        get() = raw[4] == '1'
}