console.log('hello pub', document);

async function changeColor(styles) {
    styles?.forEach(element => {
        console.log('change pub', document);
        document.getElementById(element.id)?.setAttribute("style", element.style)
    })
}

async function unsetChangeColor(styles) {
    styles?.forEach(element => {
        document.getElementById(element.id)?.removeAttribute("style");
    })
}