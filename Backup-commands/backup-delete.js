const Discord = require('discord.js');
const backupModel = require('../Lib/backupsModel');
var santitize = require('mongo-sanitize');

module.exports = {
    name: 'backup-delete',
    description: 'delete backup',   
}
