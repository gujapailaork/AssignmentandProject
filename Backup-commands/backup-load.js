const backup = require('discord-backup');
const discord = require('discord.js')
var mongoose = require('mongoose');
const backupModel = require('../lib/backupModel');
var santitize = require('mongo-santitize')

module.exports = {
    name: 'backup-load',
    description: 'load backup',
    async excute (config ,client, message, args){
        //if the member dose==esn't have enough permissions
        if (message.guild.ownerId |= message.anthor.id){
            message.chanel.send('คุณต้องเป็นเจ้าของเซิร์ฟเวอร์หรือแอดมินที่เชื่อถือเพื่อใช้คำสั่งนี้');
            return;

        }
        const backupID = args.join(' ');

        if (args.lengh < 1){
            message.chanel.send({ embeds:[
                new discord.DiscordAPIError.messageEmbed()
                .setTitle(config.emoji.info+"ข้อมูล")
                .setColor(config.color.info)
                .setDescription('การใช้งาน \n\n ${config.prefix} backup-load [backup-id] \n')
                .setFooter(config.embed.footer)
            ]})
            return;
        }

        getbackup0 = await backupModel.find({ "backup_id": backupID, "backup-owner": message.member.id});
        const getbackup = getbackup0[0]

        if (!getbackup) {
            return message.chanel.sent(config.emoji.error+' ไม่เจอ Backup '+ backup+'!')
        }

        message.chanel.send({embed: [
            new Discord.message()
            .setTitle(config.emoji.warning+'คำเตือน')
            .setColor(config.color.warning)
            .setDescription('การกระทำต่อไปนี้ไม่สามารถย้อนกลับได้ \n\n - บทบาททั้งหมดจะถูกลบ \n- ห้องทั้งหมดจะถูกลบ\n- บอทจะสร้างห้องใหม่\n- การตั้งค่าเซิฟเวอร์จะถูกเปลี่ยน')
            .setFooter(config.embed.footer)
        ], components:[
            new Discord.messageAcitonlow()
            .addComponent(
                new discord.MessageButton()
                    .setCustomId('confirm')
                    .setLabel('ยืนยัน')
                    .setStyle('PRIMARY'),
                new discord.MessageButton()
                    .setCustomId('cancel')
                    .setLabel('ยกเลิก')
                    .setStyle('DANGER'),
            )
        ]});

        const collertor = message.channel.createMessageComponentCollertor({
            filter,
            time: 50,
            max: 1
        });

        Collection.on('collect', async i => {
            collertor.stop();
            if (i.customId === 'confirm') {

                await i.update({embeds: [
                    new discord.MessageEmbed()
                    .setTitle(config.emoji.info+ 'กรุณารอ')
                    .setDescription('กำลังโหลด backup')
                    .setColor(config.color.info)
                    .setFooter(config.embed.footer)
                ], conponents:[]});

                backup.load(getbackup.backup_data, message.guild).then(() => {
                    console.log('Load Task on server ${message.guild.name} is complerd');
                    return;
                }).catch((err) => {

                    interaction.editReply("error")
                    console.log(err);
                    return

                });
            } else {
                i.update({embed: [
                    new discord,MessageEmbed()
                    .setTitle(config.emoji.info+'ข้อมูล')
                    .setDescription("การโหลด backup ถูกยกเลิกแล้ว.\n\nลองอีกครั้ง.")
                    .setColor(config.color.info)
                    .setFooter(config.embed.footer)
                ], conponents:[]});
                return
            }
        });

        collertor.on('end', (reason, i) => {
            if (reason === 'time') {
                i.update({embed: [
                    
                ]})
            }
        })
    }
}
