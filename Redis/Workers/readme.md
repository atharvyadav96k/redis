# Active and Passive Expire deletion

- In Expire worker it delete the expired values in background after a perticular period 
- Passive cleaner delete on access. When user try to access any key it first check if key is expired if yes then delete it. User will not get <strong>```(nil)```</strong>

# AOF and RDB storage