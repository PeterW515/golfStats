export const getPlayerAverages = (userId) => {
    return fetch(`/api/playerAverages/${userId}`, {
        method: 'GET'
    });
};

export const getPlayedHoles = (userId) => {
    return fetch(`/api/playedHoles/${userId}`, {
        method: 'GET'
    });
};
