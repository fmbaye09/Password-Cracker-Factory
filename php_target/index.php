<?php
$success = false;
if (isset($_POST['login']) && isset($_POST['password'])) {
    $login = $_POST['login'];
    $password = $_POST['password'];
    if ($login === 'admin' && $password === 'abcd12') {
        $success = true;
    }
}
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Authentification</title>
</head>
<body>
    <h2>Connexion</h2>
    <form method="post">
        <label>Login : <input type="text" name="login"></label><br>
        <label>Mot de passe : <input type="password" name="password"></label><br>
        <button type="submit">Se connecter</button>
    </form>
    <?php if (isset($_POST['login'])): ?>
        <p><?php echo $success ? 'Connexion reussie' : 'Echec de la connexion'; ?></p>
    <?php endif; ?>
</body>
</html> 