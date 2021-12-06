console.log('hello gen', document);

export const changeColor = (styles) => {
    console.log('this is running')
    styles?.forEach(element => {
        document.getElementById(element.id)?.setAttribute("style", element.style)
    })
}

export const unsetChangeColor = (styles) => {
    styles?.forEach(element => {
        document.getElementById(element.id)?.removeAttribute("style");
    })
}