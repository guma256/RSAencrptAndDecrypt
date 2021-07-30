<?php 


                  #******READ ME******
                  #Remember to make sure these keys only have readonly permissions
                  #Incase you don't know how to generate the Keys, below are the commands.
                  #1. openssl genrsa -out private_key.pem 2048   //Generating Private key
                  #2. openssl rsa -in private_key.pem -outform PEM -pubout -out public_key.pem
                  #3. Make sure you confirm if the data string and decrpted data are matching. If means data has been compromised

                $data_string ="Baguma is always smart";
                echo "Data Sring to encrypt :".$data_string;
                $publickKey = openssl_pkey_get_public(file_get_contents('public_key.pem'));
                $EncryptedData = "";
                openssl_public_encrypt($data_string, $EncryptedData, $publickKey);
                echo $EncryptedData;
                 echo '<br/>';


                echo "Decrypted Data";
                echo '<br/>';
                $privateKey = openssl_pkey_get_private(file_get_contents('private_key.pem'));
                $DecryptedData = "";
                openssl_private_decrypt($EncryptedData, $DecryptedData, $privateKey);
                echo $DecryptedData;
