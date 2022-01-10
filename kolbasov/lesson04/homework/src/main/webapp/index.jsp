<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ilya Kolbasov</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<style>
    body {
        background-color: #F6DDCC ;
        font-family: 'Raleway';
    }
    .all-structure {
        position: relative;
        width: 595px;
        height: 842px;
        background-color: white;
        margin: auto;
        margin-top: 8px;
    }

    /* Начало cтилей для блока header */
    .header-photo {
        position: absolute;
        width: 120px;
        left: 443px;
        top: 57px;
        border-radius: 60px;
    }
    .header-title {
        position: absolute;
        width: 258px;
        height: 87px;
        left: 29px;
        top: 69px;

    }
    .header-title-name {
        position: absolute;
        width: 57px;
        height: 28px;
        left: 1px;
        top: 0px;

        font-weight: 300;
        font-size: 24px;
        letter-spacing: 0.05em;

        color: #000000;
    }
    .header-title-name::before {
        content: '';
        background: black;
        display: inline-block;
        height: 1px;
        position: absolute;
        top: -38px;
        left: -27px;

        vertical-align: text-top;
        width: 110%;
        transform: rotate(90deg);
    }
    .header-title-surname {
        position: absolute;
        width: 258px;
        height: 47px;
        left: 0px;
        top: 24px;


        font-weight: 600;
        font-size: 40px;
        text-transform: uppercase;

        letter-spacing: 0.2em;

        color: #000000;
    }
    .header-title-surname::after {
        content: '';
        background: black;
        display: inline-block;
        height: 1px;
        position: absolute;
        top: 93px;
        left: -38.5px;
        width: 34%;
        transform: rotate(90deg);
    }
    .header-title-job {
        position: absolute;
        width: 123px;
        height: 16px;
        left: 198px;
        top: 71px;

        font-weight: 300;
        font-size: 14px;
        letter-spacing: 0.05em;

        color: #000000;

        margin: 0;
    }
    /* Начало cтилей для блока contact */
    .contact-section {
        position: absolute;
        width: 125px;
        height: 124px;
        left: 23px;
        top: 243px;

    }
    .contact-section-header {
        position: absolute;
        width: 83px;
        height: 16px;
        left: 9px;
        top: 0px;
        margin-top: 0;

        font-weight: 600;
        font-size: 14px;
        letter-spacing: 0.2em;
        text-transform: uppercase;

        color: #000000;
    }
    .contact-section-location-image {
        position: absolute;
        width: 18px;
        height: 18px;
        left: 0px;
        top: 44px;
    }
    .contact-section-location-description {
        position: absolute;
        width: 85px;
        height: 12px;
        left: 30px;
        top: 47px;

        font-weight: 300;
        font-size: 10px;

        letter-spacing: 0.05em;

        color: #676767;
        margin: 0;
    }
    .contact-section-number-image {
        position: absolute;
        width: 18px;
        height: 18px;
        left: 0px;
        top: 70px;
    }
    .contact-section-number-description {
        position: absolute;
        width: 95px;
        height: 12px;
        left: 30px;
        top: 73px;
        margin-top: 0;
        font-weight: 300;
        font-size: 10px;

        letter-spacing: 0.05em;

        color: #676767;
    }
    .contact-section-mail-image {
        position: absolute;
        width: 18px;
        height: 18px;
        left: 0px;
        top: 96px;
    }
    .contact-section-mail-description {
        position: absolute;
        width: 55px;
        height: 12px;
        left: 30px;
        top: 99px;
        margin-top: 0;

        font-weight: 300;
        font-size: 10px;

        letter-spacing: 0.05em;

        color: #676767;

    }
    /* Начало cтилей для блока profile */
    .profile-section {
        position: absolute;
        width: 350px;
        height: 111px;
        left: 213px;
        top: 243px;

    }
    .profile-section-header {
        position: absolute;
        width: 74px;
        height: 16px;
        left: 0px;
        top: 0px;
        margin: 0;

        font-weight: 600;
        font-size: 14px;
        letter-spacing: 0.2em;
        text-transform: uppercase;

        color: #000000;
    }
    .profile-section-description {
        position: absolute;
        width: 350px;
        height: 64px;
        left: 0px;
        top: 47px;
        margin: 0;

        font-weight: 300;
        font-size: 10px;
        letter-spacing: 0.05em;

        color: #676767;
    }
    /* Начало cтилей для блока skills */
    .skills-section {
        position: absolute;
        width: 96px;
        height: 130px;
        left: 25px;
        top: 405px;
    }
    .skills-section-header {
        position: absolute;
        width: 61px;
        height: 16px;
        left: 7px;
        top: 0px;
        margin: 0;

        font-weight: 600;
        font-size: 14px;
        letter-spacing: 0.2em;
        text-transform: uppercase;

        color: #000000;
    }
    .skills-section-list {
        position: absolute;
        width: 95px;
        height: 122px;
        left: 17px;
        top: 24px;
        padding: 0;

    }
    ul  li {
        font-weight: 300;
        font-size: 10px;
        margin: 8px 0px;

        letter-spacing: 0.05em;
        color: #676767;
    }
    /* Начало cтилей для блока experience */
    .experience-section {
        position: absolute;
        width: 354px;
        height: 92px;
        left: 209px;
        top: 405px;
    }
    .experience-section-header {
        position: absolute;
        width: 111px;
        height: 16px;
        left: 4px;
        top: 0px;
        margin-top: 0;

        font-weight: 600;
        font-size: 14px;
        letter-spacing: 0.2em;
        text-transform: uppercase;

        color: #000000;
    }
    .experience-section-description {
        position: absolute;
        width: 350px;
        height: 64px;
        left: 0px;
        top: 47px;
        margin-top: 0;

        font-weight: 300;
        font-size: 10px;
        letter-spacing: 0.05em;

        color: #676767;
    }
    /* Начало cтилей для блока language */
    .language-section {
        position: absolute;
        width: 125px;
        height: 112px;
        left: 28.5px;
        top: 573px;

    }
    .language-section-header {
        position: absolute;
        width: 104px;
        height: 16px;
        left: 3.5px;
        top: 0px;
        margin: 0;

        font-weight: 600;
        font-size: 14px;
        letter-spacing: 0.2em;
        text-transform: uppercase;

        color: #000000;
    }
    .language-section-list {
        position: absolute;
        width: 95px;
        height: 122px;
        left: 17px;
        top: 24px;
        padding: 0;
    }
    /* Начало cтилей для блока education */
    .education-section {
        position: absolute;
        width: 354px;
        height: 92px;
        left: 209px;
        top: 573px;
    }
    .education-section-header {
        position: absolute;
        width: 111px;
        height: 16px;
        left: 4px;
        top: 0px;
        margin-top: 0;

        font-weight: 600;
        font-size: 14px;
        letter-spacing: 0.2em;
        text-transform: uppercase;

        color: #000000;
    }
    .education-section-list {
        position: absolute;
        width: 354px;;
        height: 122px;
        left: 17px;
        top: 24px;
        padding: 0;
    }

</style>
<body>
<div class="all-structure">
    <div class="header">
        <img class="header-photo" src="./icons/me.jpg" alt="My photo">
        <div class="header-title">
            <h1><span class="header-title-name">Ilya</span><span class="header-title-surname">Kolbasov</span></h1>
            <p class="header-title-job">Junior java-developer</p>
        </div>
    </div>
    <div class="contact-section">
        <h2 class="contact-section-header">Contact</h2>
        <div class="contact-section-location">
            <img class="contact-section-location-image" src="./icons/place.png" alt="Place">
            <p class="contact-section-location-description">Minsk, Belarus</p>
        </div>
        <div class="contact-section-number">
            <img class="contact-section-number-image" src="./icons/local_phone.png" alt="Phone">
            <p class="contact-section-number-description">+375 29 540-32-58</p>
        </div>
        <div class="contact-section-mail">
            <img class="contact-section-mail-image" src="./icons/local_post_office.png" alt="Post office">
            <p class="contact-section-mail-description">Kolbiskolbis <br> @gmail.com</p>
        </div>
    </div>
    <div class="profile-section">
        <h2 class="profile-section-header">Profile</h2>
        <p class="profile-section-description">I am a hardworking and ambitious individual with a great passion for back-end develop. I am currently  trainee in It-Academy. I have excellent communication skills, enabling me to effectively communicate with a wide range of people. I am seeing a part-time position in the industry in which I can put into practice my knowledge and experience, ultimately benefiting the operations of the organisation that I work for. </p>
    </div>
    <div class="skills-section">
        <h2 class="skills-section-header">Skills</h2>
        <ul class="skills-section-list">
            <li>Git, GitHub</li>
            <li>Java SE</li>
            <li>SQL</li>
        </ul>
    </div>
    <div class="experience-section">
        <h2 class="experience-section-header">Experience</h2>
        <p class="experience-section-description">I havent had working experience as a back-end developer yet.</p>
    </div>
    <div class="language-section">
        <h2 class="language-section-header">Languages</h2>
        <ul class="language-section-list">
            <li>Russian - Native</li>
            <li>Belarusian - Native</li>
            <li>English-Pre - intermediate</li>
        </ul>
    </div>
    <div class="education-section">
        <h2 class="education-section-header">Education</h2>
        <ul class="education-section-list">
            <li>IT-Academy</li>
            <li>BSUIR</li>
        </ul>
    </div>
</div>
</body>
</html>