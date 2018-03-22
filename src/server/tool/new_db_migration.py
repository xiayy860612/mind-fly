"""
create flyway db db.migration file with below format:
    V<timestamp>__<message>.sql

command line: python new_db_migration <message>
"""
import os
import sys
import getopt
import datetime
import time

def get_file_message(msg):
    if not msg or msg == '':
        raise "no message description"
    return msg


def get_target_dir(target):
    if not target:
        raise "target directory is null or empty"
    
    ab_path = target
    if ab_path.startswith('.'):
        ab_path = os.path.abspath(target)
    
    if not os.path.exists(ab_path):
        raise "target dirctory is not existed"

    return ab_path

def get_params(args):
    param_handlers = {
        '-m': get_file_message,
        '-t': get_target_dir
    }
    opt_params = {}
    opts, other_args = getopt.getopt(args, 'hm:t:')
    for opt, value in opts:
        if opt in param_handlers:
            value = param_handlers[opt](value)
        opt_params[opt] = value
    return opt_params, other_args

def utc_now_ms():
    # get utc now in million seconds
    now_ms = time.time() * 1000
    r_now_ms = int(round(now_ms))
    return r_now_ms

def create_db_migration_file(message, target_dir):
    timestamp = utc_now_ms()
    file_message = '_'.join(message.split())
    file_name = "V{}__{}.sql".format(timestamp, file_message)
    print(file_name)
    file_path = os.path.join(target_dir, file_name)
    open(file_path, 'w').close()
    print("create db db.migration file in {}".format(file_path))

    

def help_info():
    info = """command line: 
    python new_db_migration.py -m <message> -t <targe_dir>

    Options:
        -m: db.migration message
        -t: target directory, create db.migration file in it
        -h: help info
    """
    print(info)


def main_func(argv):
    opt_params, other_args = get_params(argv[1:])
    if '-h' in opt_params:
        help_info()
        return
    
    if '-m' not in opt_params:
        raise "no message"
    
    if '-t' not in opt_params:
        raise "no target directory param"
    
    message = opt_params['-m']
    target_dir = opt_params['-t']
    create_db_migration_file(message, target_dir)


if __name__ == "__main__":
    main_func(sys.argv)
    