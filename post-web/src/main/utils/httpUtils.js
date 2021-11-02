export const getUrlJson = async url => {
    const promise = await fetch(url, {
        method: "GET",
    })

    const json = await promise.json()
    return json
}
