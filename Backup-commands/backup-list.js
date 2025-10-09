const backup = require('discord-backup');
const discord = require('discord.js');
const backupModel = require('../Lib/backupModel');
var santitize = require('mongo-santitize');
const { Module } = require('module');
const { ifError } = require('assert');

module.exports = {
    name: 'backup-list',
    description: 'list backups',
    async execute (config , clinet , interaction , srgs , serverdata){
        // If the member doesn't have enough permissions

        getbackup = await backupModel.find({"backup_owner": interaction.member.id});

        if(getbackup.lengh < 1) {
            interaction.editReply({ embed:[
                new discord.MessageEmbed()
                .setTitle(config.emoji.info+"ข้อมูล")
                .setColor(config.color.info)
                .setDescription(" คุณไม่มี backup ")
                .setFooter(config.embed.footer)
            ] })
            return;
        }

        var bklist = getbackup.map((entry) => {
            return { name: entry.backup_id, value: `${entry.backup_data.name} (\`${entry.backup_time} UTC\`)`, inline: false }
        })

        interaction.editReply({ embed: [
            new discord.MessageEmbed()
            .setTitle(config.emoji.info+ "ข้อมูล")
            .setColor(config.color.info)
            .setDescription(" backup ทั้งหมดของคุณ ")
            .addFields(bklist)
            .setFooter(config.embed.footer)
        ] })
    }
};

Collector.on('end' , (reason, i) => {
    if (reason === 'time') {
        i.update({embeds: [
            new discord.MessageEmbed()
            .setTitle(config.emoji.info+ 'ข้อมูล')
            .setDescription('การโหลด backup ถูกยกเลิกแล้ว. \n\nลองอีกครั้ง')
            .setColor(config.color.info)
            .setFooter(config.embed.footer)
        ], conponent:[]})
        return
    }
});

const mainNav = document.body.querySelector('#mainNav');
if (mainNav) {
    new bootstrap.ScrollSpy(document.body, {
        target: '#mainNav',
        rootMargin: '0px 0px -40%',
    });
};


