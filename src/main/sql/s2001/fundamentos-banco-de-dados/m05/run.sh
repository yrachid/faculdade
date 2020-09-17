docker run \
  --rm \
  --name unisinos-db \
  --env POSTGRES_PASSWORD=abc123 \
  --env POSTGRES_DB=unisinos \
  --env POSTGERS_USER=unisinos \
  --volume "${PWD}/db-setup:/docker-entrypoint-initdb.d" \
  postgres
