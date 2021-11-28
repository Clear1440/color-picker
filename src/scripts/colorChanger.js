export async function changeColor(styles) {
    styles?.forEach(element => {
        document.getElementById(element.id)?.setAttribute("style", element.style)
    })
}