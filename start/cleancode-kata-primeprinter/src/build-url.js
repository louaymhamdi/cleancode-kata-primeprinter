function normalizeBaseUrl(url) {
    if (url === null || typeof url === 'object') {
        return '';
    }
    return url;
}

function buildPathSegment(path) {
    if (!path) return '';
    return '/' + path.replace(/^\/+/, '');
}

function buildQueryString(queryParams) {
    if (!queryParams || Object.keys(queryParams).length === 0) return '';

    const queryString = Object.entries(queryParams)
        .map(([key, value]) => `${encodeURIComponent(key)}=${encodeURIComponent(value)}`)
        .join('&');

    return '?' + queryString;
}

function buildHashSegment(hash) {
    if (!hash) return '';
    return '#' + hash;
}

function buildUrl(url, options = {}) {
    if (typeof url === 'object') {
        options = url;
        url = null;
    }

    return [
        normalizeBaseUrl(url),
        buildPathSegment(options.path),
        buildQueryString(options.queryParams),
        buildHashSegment(options.hash)
    ].join('');
}