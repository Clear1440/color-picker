export async function changeColor(styles) {
    styles?.forEach(element => {
        document.getElementById(element.id)?.setAttribute("style", element.style)
    })
}

export async function unsetChangeColor(styles) {
    styles?.forEach(element => {
        document.getElementById(element.id)?.removeAttribute("style");
    })
}