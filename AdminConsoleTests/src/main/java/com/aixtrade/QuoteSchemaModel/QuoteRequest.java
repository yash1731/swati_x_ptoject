package com.aixtrade.QuoteSchemaModel;


public class QuoteRequest {

        private Long quoteRequestId;
        private String symbol;
        private String quantity;
        private String channel;
        private String direction;
        private String trader;
        private String status;
        private Double spotPrice;
        private String expirationInSeconds;
        private String expiresAt;
        private String createdAt;

        public long getQuoteRequestId() {
            return quoteRequestId;
        }

        public void setQuoteRequestId(long quoteRequestId) {
            this.quoteRequestId = quoteRequestId;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getTrader() {
            return trader;
        }

        public void setTrader(String trader) {
            this.trader = trader;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public double getSpotPrice() {
            return spotPrice;
        }

        public void setSpotPrice(double spotPrice) {
            this.spotPrice = spotPrice;
        }

        public String getExpirationInSeconds() {
            return expirationInSeconds;
        }

        public void setExpirationInSeconds(String expirationInSeconds) {
            this.expirationInSeconds = expirationInSeconds;
        }

        public String getExpiresAt() {
            return expiresAt;
        }

        public void setExpiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
}
