function AuthorizationError(description) {
    this.message = "Acesso Negado";
    this.description = description;
}

AuthorizationError.prototype = Object.create(Error.prototype);
AuthorizationError.prototype.constructor = AuthorizationError;


