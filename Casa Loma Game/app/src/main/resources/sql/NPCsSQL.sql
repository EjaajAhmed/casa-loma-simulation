-- Create the NPCs table
CREATE TABLE IF NOT EXISTS NPCs (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Primary Key for each NPC
    name VARCHAR(100) NOT NULL,        
    loi DOUBLE NOT NULL,             
    randomJobs TEXT,                   
    randomLines TEXT                   
);

-- Insert initial NPC data (optional)
INSERT INTO NPCs (name, loi, randomJobs, randomLines) VALUES
('Alejandro', 0.5, 'I need 5 chairs to the library. Yesterday!,What you standing around for? Get me some water bottles. Leave them in the conservatory!,Move the gelato cart, front of castle, please!', 'How are you doing, sir!,Move!,¡Mira a este pequeño!'),
('Bob', 0.7, 'What bus you waiting for? You just standing here! Help us move the fountain!,Who are you? Whatever bring me the master keys from security.,Here change the lightbulb in the peacock alley. What do you mean not part of your job description?', 'What bus you waiting for? Cuz you\'re just standing there!,A dollar a day keeps HR away! (Old man laugh),Working hard or hardly working?'),
('Becky', 0.25, 'Umm, could you, like, get me a chair please? I need it in the great hall. Thanks sis!,Apple watermelon is my favourite flavour and I lost it! Can you find my vape? I dropped it in the ,Hey, the umbrella on the terrace flew away and hit a woman. It\'s giving Diddy. Can you fix it?', 'oh my gawd have you seen my vape? can I hit urs then? You DON\'T have one...,SZA just dropped an album!!!,OMG I luv ur pants. its giving will smith in pursuit of happiness'),
('Preet', 0.4, 'Brother, can you put high top table by entrance, please brother. Thank you.,Hey bro give me one table please. Library, brother.,Bro I need help outside. The big pot needs move, brother.', 'How you, brotha? I\'m good.,Bro, I have nephew, he need job. You guys hiring? Let me know.,Hot day today, you guys drink water.');
