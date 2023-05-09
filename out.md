## Tables
|                      Table Name|                     Column Name|                       Data Type|                  Related Tables|                     Description|
|               -----------------|               -----------------|               -----------------|               -----------------|               -----------------|
|                   decrypted_key|                                |                                |                                |                                |
|                                |                 associated_data|                            text|                                |                                |
|                                |                   raw_key_nonce|                           bytea|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                        key_type|                    USER-DEFINED|                                |                                |
|                                |                         raw_key|                           bytea|                                |                                |
|                                |                         expires|        timestamp with time zone|                                |                                |
|                                |                          key_id|                          bigint|                                |                                |
|                                |                      parent_key|                            uuid|                                |                                |
|                                |                         created|        timestamp with time zone|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |                         comment|                            text|                                |                                |
|                                |                     key_context|                           bytea|                                |                                |
|                                |                          status|                    USER-DEFINED|                                |                                |
|                                |               decrypted_raw_key|                           bytea|                                |                                |
|               audit_log_entries|                                |                                |                                |                                |
|                                |                      ip_address|               character varying|                                |                                |
|                                |                         payload|                            json|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                     instance_id|                            uuid|                                |                                |
|                         buckets|                                |                                |                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                 file_size_limit|                          bigint|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            text|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |              avif_autodetection|                         boolean|                                |                                |
|                                |                           owner|                            uuid|                                |                                |
|                                |                          public|                         boolean|                                |                                |
|                                |              allowed_mime_types|                           ARRAY|                                |                                |
|                        sessions|                                |                                |                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                       factor_id|                            uuid|                                |                                |
|                                |                             aal|                    USER-DEFINED|                                |                                |
|                                |                         user_id|                            uuid|                                |                                |
|                                |                       not_after|        timestamp with time zone|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                    masking_rule|                                |                                |                                |                                |
|                                |                    relnamespace|                    regnamespace|                                |                                |
|                                |              associated_columns|                            text|                                |                                |
|                                |                 col_description|                            text|                                |                                |
|                                |                          key_id|                            text|                                |                                |
|                                |                       view_name|                            text|                                |                                |
|                                |                   key_id_column|                            text|                                |                                |
|                                |                        priority|                         integer|                                |                                |
|                                |                          attnum|                         integer|                                |                                |
|                                |                     format_type|                            text|                                |                                |
|                                |                    nonce_column|                            text|                                |                                |
|                                |                         relname|                            name|                                |                                |
|                                |                        attrelid|                             oid|                                |                                |
|                                |                         attname|                            name|                                |                                |
|                      flow_state|                                |                                |                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |           authentication_method|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                  code_challenge|                            text|                                |                                |
|                                |           code_challenge_method|                    USER-DEFINED|                                |                                |
|                                |                   provider_type|                            text|                                |                                |
|                                |           provider_access_token|                            text|                                |                                |
|                                |                       auth_code|                            text|                                |                                |
|                                |          provider_refresh_token|                            text|                                |                                |
|                                |                         user_id|                            uuid|                                |                                |
|                      migrations|                                |                                |                                |                                |
|                                |                     executed_at|     timestamp without time zone|                                |                                |
|                                |                            name|               character varying|                                |                                |
|                                |                              id|                         integer|                                |                                |
|                                |                            hash|               character varying|                                |                                |
|                         secrets|                                |                                |                                |                                |
|                                |                          key_id|                            uuid|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                     description|                            text|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                           nonce|                           bytea|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |                          secret|                            text|                                |                                |
|                    mask_columns|                                |                                |                                |                                |
|                                |                   key_id_column|                            text|                                |                                |
|                                |              associated_columns|                            text|                                |                                |
|                                |                         attname|                            name|                                |                                |
|                                |                          key_id|                            text|                                |                                |
|                                |                    nonce_column|                            text|                                |                                |
|                                |                        attrelid|                             oid|                                |                                |
|                                |                     format_type|                            text|                                |                                |
|                      identities|                                |                                |                                |                                |
|                                |                 last_sign_in_at|        timestamp with time zone|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            text|                                |                                |
|                                |                           email|                            text|                                |                                |
|                                |                        provider|                            text|                                |                                |
|                                |                         user_id|                            uuid|                                |                                |
|                                |                   identity_data|                           jsonb|                                |                                |
|               schema_migrations|                                |                                |                                |                                |
|                                |                         version|               character varying|                                |                                |
|                                |                     inserted_at|     timestamp without time zone|                                |                                |
|                                |                         version|                          bigint|                                |                                |
|                    subscription|                                |                                |                                |                                |
|                                |                              id|                          bigint|                                |                                |
|                                |                     claims_role|                         regrole|                                |                                |
|                                |                      created_at|     timestamp without time zone|                                |                                |
|                                |                 subscription_id|                            uuid|                                |                                |
|                                |                          claims|                           jsonb|                                |                                |
|                                |                          entity|                        regclass|                                |                                |
|                                |                         filters|                           ARRAY|                                |                                |
|                  mfa_amr_claims|                                |                                |                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                      session_id|                            uuid|                                |                                |
|                                |           authentication_method|                            text|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|              pg_stat_statements|                                |                                |                                |                                |
|                                |             jit_generation_time|                double precision|                                |                                |
|                                |              jit_emission_count|                          bigint|                                |                                |
|                                |                            dbid|                             oid|                                |                                |
|                                |                   max_exec_time|                double precision|                                |                                |
|                                |                   max_plan_time|                double precision|                                |                                |
|                                |                           calls|                          bigint|                                |                                |
|                                |              jit_inlining_count|                          bigint|                                |                                |
|                                |                  local_blks_hit|                          bigint|                                |                                |
|                                |                  mean_exec_time|                double precision|                                |                                |
|                                |               temp_blks_written|                          bigint|                                |                                |
|                                |              local_blks_written|                          bigint|                                |                                |
|                                |              temp_blk_read_time|                double precision|                                |                                |
|                                |                  temp_blks_read|                          bigint|                                |                                |
|                                |                   blk_read_time|                double precision|                                |                                |
|                                |                   min_exec_time|                double precision|                                |                                |
|                                |                stddev_exec_time|                double precision|                                |                                |
|                                |                   jit_functions|                          bigint|                                |                                |
|                                |               jit_emission_time|                double precision|                                |                                |
|                                |                  blk_write_time|                double precision|                                |                                |
|                                |          jit_optimization_count|                          bigint|                                |                                |
|                                |                 local_blks_read|                          bigint|                                |                                |
|                                |                           query|                            text|                                |                                |
|                                |                 total_exec_time|                double precision|                                |                                |
|                                |                 shared_blks_hit|                          bigint|                                |                                |
|                                |                 total_plan_time|                double precision|                                |                                |
|                                |                         wal_fpi|                          bigint|                                |                                |
|                                |             shared_blks_dirtied|                          bigint|                                |                                |
|                                |             shared_blks_written|                          bigint|                                |                                |
|                                |                          userid|                             oid|                                |                                |
|                                |                         queryid|                          bigint|                                |                                |
|                                |                     wal_records|                          bigint|                                |                                |
|                                |                           plans|                          bigint|                                |                                |
|                                |                shared_blks_read|                          bigint|                                |                                |
|                                |                            rows|                          bigint|                                |                                |
|                                |                   min_plan_time|                double precision|                                |                                |
|                                |                  mean_plan_time|                double precision|                                |                                |
|                                |                        toplevel|                         boolean|                                |                                |
|                                |           jit_optimization_time|                double precision|                                |                                |
|                                |              local_blks_dirtied|                          bigint|                                |                                |
|                                |                       wal_bytes|                         numeric|                                |                                |
|                                |               jit_inlining_time|                double precision|                                |                                |
|                                |             temp_blk_write_time|                double precision|                                |                                |
|                                |                stddev_plan_time|                double precision|                                |                                |
|                       instances|                                |                                |                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                 raw_base_config|                            text|                                |                                |
|                                |                            uuid|                            uuid|                                |                                |
|                   sso_providers|                                |                                |                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                     resource_id|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                           posts|                                |                                |                                |                                |
|                                |                        end_time|     timestamp without time zone|                                |                                |
|                                |                          styles|                            text|                                |                                |
|                                |                      start_time|     timestamp without time zone|                                |                                |
|                                |                      profile_id|                            uuid|                                |                                |
|                                |                      created_at|     timestamp without time zone|                                |                                |
|                                |                          gym_id|                            uuid|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                  saml_providers|                                |                                |                                |                                |
|                                |                 sso_provider_id|                            uuid|                                |                                |
|                                |               attribute_mapping|                           jsonb|                                |                                |
|                                |                       entity_id|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                    metadata_xml|                            text|                                |                                |
|                                |                    metadata_url|                            text|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                     mfa_factors|                                |                                |                                |                                |
|                                |                   friendly_name|                            text|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                          status|                    USER-DEFINED|                                |                                |
|                                |                          secret|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                         user_id|                            uuid|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                     factor_type|                    USER-DEFINED|                                |                                |
|                         objects|                                |                                |                                |                                |
|                                |                         version|                            text|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                     path_tokens|                           ARRAY|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |                        metadata|                           jsonb|                                |                                |
|                                |                last_accessed_at|        timestamp with time zone|                                |                                |
|                                |                           owner|                            uuid|                                |                                |
|                                |                       bucket_id|                            text|                                |                                |
|         pg_stat_statements_info|                                |                                |                                |                                |
|                                |                     stats_reset|        timestamp with time zone|                                |                                |
|                                |                         dealloc|                          bigint|                                |                                |
|                        profiles|                                |                                |                                |                                |
|                                |                         website|                            text|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                        username|                            text|                                |                                |
|                                |                      avatar_url|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                     sso_domains|                                |                                |                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                 sso_provider_id|                            uuid|                                |                                |
|                                |                          domain|                            text|                                |                                |
|               saml_relay_states|                                |                                |                                |                                |
|                                |                      request_id|                            text|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                       for_email|                            text|                                |                                |
|                                |                     redirect_to|                            text|                                |                                |
|                                |                 from_ip_address|                            inet|                                |                                |
|                                |                 sso_provider_id|                            uuid|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                             key|                                |                                |                                |                                |
|                                |                   raw_key_nonce|                           bytea|                                |                                |
|                                |                         raw_key|                           bytea|                                |                                |
|                                |                        key_type|                    USER-DEFINED|                                |                                |
|                                |                         expires|        timestamp with time zone|                                |                                |
|                                |                         created|        timestamp with time zone|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                         comment|                            text|                                |                                |
|                                |                 associated_data|                            text|                                |                                |
|                                |                          status|                    USER-DEFINED|                                |                                |
|                                |                     key_context|                           bytea|                                |                                |
|                                |                          key_id|                          bigint|                                |                                |
|                                |                      parent_key|                            uuid|                                |                                |
|                                |                       user_data|                            text|                                |                                |
|                       valid_key|                                |                                |                                |                                |
|                                |                          key_id|                          bigint|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                        key_type|                    USER-DEFINED|                                |                                |
|                                |                         created|        timestamp with time zone|                                |                                |
|                                |                         expires|        timestamp with time zone|                                |                                |
|                                |                 associated_data|                            text|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |                     key_context|                           bytea|                                |                                |
|                                |                          status|                    USER-DEFINED|                                |                                |
|                            gyms|                                |                                |                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                           image|                            text|                                |                                |
|                                |                      created_at|     timestamp without time zone|                                |                                |
|                                |                        services|                            text|                                |                                |
|                                |                           state|                            text|                                |                                |
|                                |                            name|                            text|                                |                                |
|                                |                           email|                            text|                                |                                |
|                                |                            city|                            text|                                |                                |
|                                |                    phone_number|                            text|                                |                                |
|                                |                  address_line_1|                            text|                                |                                |
|                                |                         website|                            text|                                |                                |
|                                |                  address_line_2|                            text|                                |                                |
|                                |                        zip_code|                            text|                                |                                |
|                                |                     description|                            text|                                |                                |
|               decrypted_secrets|                                |                                |                                |                                |
|                                |                decrypted_secret|                            text|                                |                                |
|                                |                          secret|                            text|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                     description|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                           nonce|                           bytea|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                          key_id|                            uuid|                                |                                |
|                                |                            name|                            text|                                |                                |
|                           users|                                |                                |                                |                                |
|                                |                     instance_id|                            uuid|                                |                                |
|                                |        reauthentication_sent_at|        timestamp with time zone|                                |                                |
|                                |                  is_super_admin|                         boolean|                                |                                |
|                                |            confirmation_sent_at|        timestamp with time zone|                                |                                |
|                                |                 last_sign_in_at|        timestamp with time zone|                                |                                |
|                                |                           email|               character varying|                                |                                |
|                                |              encrypted_password|               character varying|                                |                                |
|                                |                    email_change|               character varying|                                |                                |
|                                |              phone_confirmed_at|        timestamp with time zone|                                |                                |
|                                |                    banned_until|        timestamp with time zone|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      invited_at|        timestamp with time zone|                                |                                |
|                                |                    confirmed_at|        timestamp with time zone|                                |                                |
|                                |              confirmation_token|               character varying|                                |                                |
|                                |      email_change_token_current|               character varying|                                |                                |
|                                |                recovery_sent_at|        timestamp with time zone|                                |                                |
|                                |              email_confirmed_at|        timestamp with time zone|                                |                                |
|                                |     email_change_confirm_status|                        smallint|                                |                                |
|                                |                  recovery_token|               character varying|                                |                                |
|                                |              raw_user_meta_data|                           jsonb|                                |                                |
|                                |                           phone|                            text|                                |                                |
|                                |            email_change_sent_at|        timestamp with time zone|                                |                                |
|                                |                      deleted_at|        timestamp with time zone|                                |                                |
|                                |                    phone_change|                            text|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |              phone_change_token|               character varying|                                |                                |
|                                |          email_change_token_new|               character varying|                                |                                |
|                                |                             aud|               character varying|                                |                                |
|                                |          reauthentication_token|               character varying|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                                |                     is_sso_user|                         boolean|                                |                                |
|                                |                            role|               character varying|                                |                                |
|                                |               raw_app_meta_data|                           jsonb|                                |                                |
|                                |            phone_change_sent_at|        timestamp with time zone|                                |                                |
|                  mfa_challenges|                                |                                |                                |                                |
|                                |                     verified_at|        timestamp with time zone|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |                      ip_address|                            inet|                                |                                |
|                                |                       factor_id|                            uuid|                                |                                |
|                  refresh_tokens|                                |                                |                                |                                |
|                                |                              id|                          bigint|                                |                                |
|                                |                           token|               character varying|                                |                                |
|                                |                     instance_id|                            uuid|                                |                                |
|                                |                         revoked|                         boolean|                                |                                |
|                                |                      session_id|                            uuid|                                |                                |
|                                |                          parent|               character varying|                                |                                |
|                                |                         user_id|               character varying|                                |                                |
|                                |                      created_at|        timestamp with time zone|                                |                                |
|                                |                      updated_at|        timestamp with time zone|                                |                                |
|                        messages|                                |                                |                                |                                |
|                                |               sender_profile_id|                            uuid|                                |                                |
|                                |                              id|                            uuid|                                |                                |
|                                |             receiver_profile_id|                            uuid|                                |                                |
|                                |                      created_at|     timestamp without time zone|                                |                                |
|                                |                         content|                            text|                                |                                |
