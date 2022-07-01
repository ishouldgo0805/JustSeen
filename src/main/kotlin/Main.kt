var userBeenAgo: UInt = 260_300U

fun main() {
    print(timeOfDay)
}

var timeOfDay = when (userBeenAgo) {
    in 0U..60U -> "Был(а) только что"
    in 61U..3599U -> "Был(а) ${userBeenAgo / 60U} ${agoToTextForMinutes(userBeenAgo)} назад"
    in 3600U..86_400U -> "Был(а) ${
        if (userBeenAgo / 3600U < 24U) "${userBeenAgo / 3600U} ${
            agoToTextForHours(
                userBeenAgo
            )
        } назад" else "сутки назад"
    }"
    in 86_401U..172_800U -> "Был(а) сегодня"
    in 172_801U..259_200U -> "Был(а) вчера"
    else -> "Был(а) давно"
}

fun agoToTextForMinutes(userBeenAgo: UInt): String {
    var time = userBeenAgo / 60U
    if (time % 10U == 1U) {
        return "минуту"
    } else if (time % 10U in 2U..4U) {
        return "минуты"
    } else return "минут"
}

fun agoToTextForHours(userBeenAgo: UInt): String {
    var time = userBeenAgo / 3600U
    if (time % 10U == 1U) {
        return "час"
    } else if (time % 10U in 2U..4U) {
        return "часа"
    } else return "часов"
}