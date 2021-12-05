console.log('hello pub', document);

export const changeColor = (styles) => {
    styles?.forEach(element => {
        console.log('change pub', document);
        document.getElementById(element.id)?.setAttribute("style", element.style)
    })
}

export const unsetChangeColor = (styles) => {
    styles?.forEach(element => {
        document.getElementById(element.id)?.removeAttribute("style");
    })
}