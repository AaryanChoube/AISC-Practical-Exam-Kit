# Experiment 9: Text Preprocessing & Cleaning UDF for Generative AI (Python)
import re
import string

def clean_text(text):
    text = str(text).lower()
    text = re.sub(r'http\S+|www\S+', '', text)
    text = re.sub(r'<.*?>', '', text)
    text = text.translate(str.maketrans('', '', string.punctuation))
    text = re.sub(r'\d+', '', text)
    text = re.sub(r'\s+', ' ', text).strip()
    return text

sample = "<p>Welcome to AISC Lab 2026! Visit http://ai.org & learn AI & NLP.</p>"
cleaned = clean_text(sample)
tokens = cleaned.split()

print("Original Text:", sample)
print("Cleaned Text :", cleaned)
print("Tokens       :", tokens)
